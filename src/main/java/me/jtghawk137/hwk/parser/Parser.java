package me.jtghawk137.hwk.parser;

import me.jtghawk137.hwk.block.Block;
import me.jtghawk137.hwk.token.Tokenizer;

public abstract class Parser<T extends Block>
{

    /**
     * Takes in a line to see if this is the correct parser using regular expressions.
     *
     * @param string
     * @return
     */
    public abstract boolean shouldParse(String string);

    /**
     * Returns a block of this parsers type.
     *
     * @param superBlock
     * @param tokenizer
     * @return
     */
    public abstract T parse(Block superBlock, Tokenizer tokenizer);
}
