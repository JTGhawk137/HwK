package me.jtghawk137.hwk.block;

public class Class extends Block
{
    // Name of the class
    private String name;

    public Class(String name)
    {
        // Returns null because there will never be anything higher than a class (At least in this language).
        super(null);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void run()
    {
        // Runs main method
    }
}
