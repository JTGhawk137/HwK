package me.jtghawk137.hwk.block;

import me.jtghawk137.hwk.Variable;

import java.util.ArrayList;

/**
 * Class representing a block in code.
 */
public abstract class Block
{

    private Block superBlock;
    private ArrayList<Block> subBlocks;
    private ArrayList<Variable> variables;

    public Block(Block superBlock)
    {
        this.superBlock = superBlock;
        subBlocks = new ArrayList<>();
        variables = new ArrayList<>();
    }

    public Block getSuperBlock()
    {
        return superBlock;
    }

    public ArrayList<Block> getSubBlocks()
    {
        return subBlocks;
    }

    public void addBlock(Block block)
    {
        subBlocks.add(block);
    }

    public Variable getVariable(String name)
    {
        for (Variable v : variables)
        {
            if (v.getName().equals(name))
            {
                return v;
            }
        }
        return null;
    }

    public void addVariable(Variable variable)
    {
        variables.add(variable);
    }

    public abstract void run();
}
