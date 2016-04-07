package me.jtghawk137.hwk.block;

import me.jtghawk137.hwk.Parameter;

public class Catch extends Block
{
    Parameter[] params;

    public Catch(Block superBlock, Parameter[] params)
    {
        super(superBlock);
        this.params = params;
    }

    @Override
    public void run()
    {

    }
}
