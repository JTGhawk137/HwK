package me.jtghawk137.hwk;

/**
 * Class to represent a parameter.
 */
public class Parameter
{

    private String name;
    private Type type;

    public Parameter(String name, Type type)
    {
        this.type = type;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }
}
