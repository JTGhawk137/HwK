package me.jtghawk137.hwk.parser;

import me.jtghawk137.hwk.Type;
import me.jtghawk137.hwk.Variable;
import me.jtghawk137.hwk.block.Block;
import me.jtghawk137.hwk.token.Token;
import me.jtghawk137.hwk.token.TokenType;
import me.jtghawk137.hwk.token.Tokenizer;

public class VariableParser extends Parser<Block>
{

    @Override
    public boolean shouldParse(String string)
    {
        return string.matches("var [a-zA-Z]+ [a-zA-Z]+ = \"?[a-zA-Z0-9]\"?");
    }

    @Override
    public Block parse(Block superBlock, Tokenizer tokenizer)
    {
        tokenizer.nextToken();
        Type type = Type.valueOf(tokenizer.nextToken().getToken());
        String name = tokenizer.nextToken().getToken();
        if (!tokenizer.nextToken().getToken().equals("=")) // Just leave it for now TODO
        {
            return null;
        }
        if (type == Type.VOID)
        {
            throw new IllegalStateException("Variables cannot be the type void");
        }
        Token value = tokenizer.nextToken();
        Object val;
        if (value.getType() == TokenType.INTEGER)
        {
            val = Integer.valueOf(value.getToken());
        } else if (value.getType() == TokenType.STRING)
        {
            val = value.getToken();
        } else if (value.getType() == TokenType.BOOL)
        {
            val = Boolean.valueOf(value.getToken());
        } else
        {
            val = superBlock.getVariable(value.getToken()).getValue();
        }
        superBlock.addVariable(new Variable(superBlock, type, name, val));
        return null;
    }
}
