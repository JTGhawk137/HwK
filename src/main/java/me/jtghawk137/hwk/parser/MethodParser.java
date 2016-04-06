package me.jtghawk137.hwk.parser;

import me.jtghawk137.hwk.Parameter;
import me.jtghawk137.hwk.Type;
import me.jtghawk137.hwk.block.Block;
import me.jtghawk137.hwk.block.Method;
import me.jtghawk137.hwk.token.Token;
import me.jtghawk137.hwk.token.Tokenizer;

import java.util.ArrayList;

public class MethodParser extends Parser<Method>
{

    @Override
    public boolean shouldParse(String string)
    {
        return string.matches("method [a-zA-Z][a-zA-Z0-9]* \\(([a-zA-Z][a-zA-Z0-9]* [a-zA-Z][a-zA-Z0-9]*)\\) [a-zA-Z]*");
    }

    @Override
    public Method parse(Block superBlock, Tokenizer tokenizer)
    {
        tokenizer.nextToken(); // Skips the method token
        String name = tokenizer.nextToken().getToken(); // Gets the method name
        tokenizer.nextToken(); // Skips the (
        Token first = tokenizer.nextToken(); // Grabs the first parameter.

        ArrayList<Parameter> params = new ArrayList<>(); // A list of all the parameters
        if (!first.getToken().equals(")")) // Makes sure there is a parameter.
        {
            String[] data = new String[]{first.getToken(), null};

            while (tokenizer.hasNextToken())
            {
                Token token = tokenizer.nextToken();

                if (token.getToken().equals(")"))
                    break;
                if (data[0] == null)
                {
                    data[0] = token.getToken(); // gets the parameter type
                } else
                {
                    data[1] = token.getToken(); // gets the parameter name
                    params.add(new Parameter(data[1], Type.valueOf(data[0].toUpperCase())));
                    data = new String[2];
                }
            }
        }
        Type type = Type.valueOf(tokenizer.nextToken().getToken().toUpperCase()); // Gets the return type of the method.
        return new Method(superBlock, name, params.toArray(new Parameter[params.size()]), type);
    }
}
