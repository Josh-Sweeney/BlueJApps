import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Samsung Galaxy S10"));
        stock.add(new Product(102, "Samsung Galaxy S9+"));
        stock.add(new Product(103, "Samsung Galaxy S9"));
        stock.add(new Product(104, "Samsung Galaxy S8+"));
        stock.add(new Product(105, "Samsung Galaxy S8"));
        stock.add(new Product(106, "Samsung Galaxy S7 Edge"));
        stock.add(new Product(107, "Samsung Galaxy S7"));
        stock.add(new Product(108, "Samsung Galaxy S6 Edge+"));
        stock.add(new Product(109, "Samsung Galaxy S6"));
        stock.add(new Product(110, "Samsung Galaxy S5"));
        stock.add(new Product(111, "Samsung Galaxy S4"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    /**
     * Buys the products from the stock with
     * random quantities
     */
    private void buyProducts()
    {
        for (int i = 101; i < 112; i++)
        {
            Product product = stock.findProduct(i);
            
            if (product != null)
            {
                stock.buyProduct(i, getRandomQuantity());
            }
            else
            {
                System.out.println("Product with ID " + i + " not found. ");
            }
        }
    }

    /**
     * Sells the products from the stock
     */
    private void sellProducts()
    {
        for (int i = 101; i < 112; i++)
        {
            // Check if the product exists
            Product product = stock.findProduct(i);

            if (product != null)
            {
                stock.sellProduct(i);
            }
            else
            {
                System.out.println("Product with ID " + i + " not found. ");
            }
        }
    }

    /**
     * Generates a random number to be used as the
     * quantity when buying products
     * @return A random number between 0 and 100
     */
    private int getRandomQuantity()
    {
        Random random = new Random();

        return random.nextInt(100);
    }
}