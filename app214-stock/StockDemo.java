import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @author Modified by Joshua Sweeney
 * @version 26/11/21
 */
public class StockDemo
{
    // The stock manager.
    private ProductList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(ProductList stock)
    {
        this.stock = stock;

        stock = getProducts();
    }

    /**
     * Returns a list of products to be added to the stock
     * list for a demo
     * @return A list of products
     */
    public ProductList getProducts()
    {
        ProductList stock = new ProductList();

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
        stock.add(new Product(110, "Galaxy S5"));
        stock.add(new Product(111, "Samsung Galaxy S4"));

        System.out.println();
        System.out.println("Added 11 unique products to the stock list. ");
        
        return stock;
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
        
        // Buy the products with random quantities
        System.out.println("Buying random amounts of each product: ");
        buyProducts();

        // Show the details of the products after buying
        stock.print();        

        // Sell 1 of each product
        System.out.println("Selling 1 of each product: ");
        sellProducts();

        // Show the details of the products after selling
        stock.print();

        // Remove the first product ("Samsung Galaxy S10")
        System.out.println("Removing the product 'Samsung Galaxy S10': ");
        stock.removeProduct(101);

        // Show the details of the products after removing the product
        stock.print();

        // List products that start with "Samsung"
        stock.printProducts("Samsung");
        
        // List products that are below 25 quantity
        stock.printProducts(25);
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