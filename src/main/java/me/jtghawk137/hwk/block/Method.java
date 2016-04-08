package me.jtghawk137.hwk.block;

import me.jtghawk137.hwk.Parameter;
import me.jtghawk137.hwk.Type;
import me.jtghawk137.hwk.Value;
import me.jtghawk137.hwk.Variable;

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

    public Value invoke(Value... values)
    {
        if (values.length != params.length)
        {
            throw new IllegalArgumentException("Difference in length between values and parameters.");
        }
        for (int i = 0; values.length > i; i++)
        {
            Parameter param = params[i];
            Value value = values[i];

            if (param.getType() != value.getType())
            {
                throw new IllegalStateException("The parameter " + param.getName() + " should be of type " + param.getType() + " but instead it got " + value.getType());
            }
            addVariable(new Variable(this, param.getType(), param.getName(), value.getValue())); // Create a new variable in the block
        }
        for (Block block : getSubBlocks()) // Run each block inside the method
        {
            block.run();
            if (value != null)
            {
                break;
            }
        }
        if (value == null && type != Type.VOID)
        {
            throw new IllegalStateException("Returned null from a method that is not void");
        }
        Value returnValue = value;
        value = null;
        return returnValue;
    }
}
