
/**
 * The main class that runs the stock program
 *
 * @author Joshua Sweeney
 * @version 26/11/21
 */
public class Program
{
    private static StockApp app;
    
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
