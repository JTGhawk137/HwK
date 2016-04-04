package me.jtghawk137.hwk.token;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer
{

    private List<TokenData> tokenData;
    private Token lastToken;
    private boolean pushBack;
    private String string;

    public Tokenizer(String string)
    {
        this.string = string;
        this.tokenData = new ArrayList<>();
        tokenData.add(new TokenData(Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*)"), TokenType.IDENTIFIER));
        tokenData.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"), TokenType.INTEGER_LITERAL));
        tokenData.add(new TokenData(Pattern.compile("^(\".*\")"), TokenType.STRING_LITERAL));

        for (String str : new String[]{"-", "\\(", "//)", "\\.", "\\,"})
        {
            tokenData.add(new TokenData(Pattern.compile("^(" + str + ")"), TokenType.TOKEN));
        }
    }

    public Token nextToken()
    {
        string = string.trim();
        if (pushBack)
        {
            pushBack = false;
            return lastToken;
        }
        if (string.isEmpty())
        {
            return (lastToken = new Token("", TokenType.EMPTY));
        }

        for (TokenData data : tokenData)
        {
            Matcher matcher = data.getPattern().matcher(string);

            if (matcher.find())
            {
                String token = matcher.group().trim();
                string = matcher.replaceFirst("");

                if (data.getType() == TokenType.STRING_LITERAL)
                {
                    return lastToken = new Token(token.substring(1, token.length() - 1), TokenType.STRING_LITERAL);
                } else
                {
                    return lastToken = new Token(token, data.getType());
                }
            }
        }
        throw new IllegalStateException("Could not parse: " + string);
    }

    public boolean hasNextToken()
    {
        return !string.isEmpty();
    }

    public void pushBack()
    {
        if (lastToken != null)
        {
            this.pushBack = true;
        }
    }
}
