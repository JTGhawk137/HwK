package me.jtghawk137.hwk.block;

import java.util.ArrayList;

/**
 * Class representing a block in code.
 */
public abstract class Block
{

    private Block superBlock;
    private ArrayList<Block> subBlocks;

    public Block(Block superBlock)
    {
        this.superBlock = superBlock;
        subBlocks = new ArrayList<>();
    }

    public Block getSuperBlock()
    {
        return superBlock;
    }

    public void addBlock(Block block)
    {
        subBlocks.add(block);
    }

    public abstract void run();
}
