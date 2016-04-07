package me.jtghawk137.hwk.block;

public class Try extends Block
{

    private String message;

    public Try(Block superBlock, String message)
    {
        super(superBlock);
        this.message = message;
    }

    @Override
    public void run()
    {

    }
}
