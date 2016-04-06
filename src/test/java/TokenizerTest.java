import me.jtghawk137.hwk.token.Tokenizer;

public class TokenizerTest
{

    public static void main(String[] args)
    {
        String code = "class lol";
        Tokenizer tokenizer = new Tokenizer(code);
        while(tokenizer.hasNextToken())
        {
            System.out.println(tokenizer.nextToken().getToken());
        }
    }
}
