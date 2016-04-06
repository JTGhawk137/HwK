package me.jtghawk137.hwk.block;

import me.jtghawk137.hwk.Parameter;
import me.jtghawk137.hwk.Type;
import me.jtghawk137.hwk.Value;

/**
 * Class to represent a method.
 */
public class Method extends Block
{

    private String name;
    private Parameter[] params;
    private Type type;
    private Value value;

    public Method(Block superBlock, String name, Parameter[] params, Type type)
    {
        super(superBlock);
        this.name = name;
        this.params = params;
        this.type = type;
    }

    @Override
    public void run()
    {

    }

    public void invoke(Value... values)
    {

    }
}
