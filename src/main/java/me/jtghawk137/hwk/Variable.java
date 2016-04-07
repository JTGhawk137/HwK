package me.jtghawk137.hwk;

import me.jtghawk137.hwk.block.Block;

public class Variable extends Value
{

    private Block block;
    private String name;

    public Variable(Block block, Type type, String name, Object value)
    {
        super(type, value);
        this.name = name;
        this.block = block;
    }

    public String getName()
    {
        return name;
    }

    public Block getBlock()
    {
        return block;
    }
}
