import java.util.Scanner;

public class LoglineTokenizer
{
    public void tokenize(String logline, int[] dataLine)
    {
        Scanner tokenizer = new Scanner(logline);
        for(int i = 0; i < dataLine.length; i++) {
            dataLine[i] = tokenizer.nextInt();
        }
    }
}
