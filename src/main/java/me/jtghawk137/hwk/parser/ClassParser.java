package me.jtghawk137.hwk.parser;

import me.jtghawk137.hwk.block.Block;
import me.jtghawk137.hwk.block.Class;
import me.jtghawk137.hwk.token.Tokenizer;

public class ClassParser extends Parser<Class>
{
    @Override
    public boolean shouldParse(String string)
    {
        return string.matches("class [a-zA-Z]*");
    }

    @Override
    public Class parse(Block superBlock, Tokenizer tokenizer)
    {
        tokenizer.nextToken(); // We are skipping the class token so we can grab the class name.
        String name = tokenizer.nextToken().getToken(); // Getting the token (Name of the class).
        return new Class(name);
    }
}
