
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private ProductList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new ProductList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        switch(choice)
        {
            case "add":
                addProduct();
                break;
            case "buy":
                buyProduct();
                break;
            case "sell":
                sellProduct();
                break;
            case "remove":
                removeProduct();
                break;
            case "print":
                stock.print();
                break;
            case "quit":
                return true;
            default:
                System.out.println("Invalid option selected. ");
            break;
        }
        
        return false;
    }
    
    /**
     * Add's a new product to the product list using
     * user input
     */
    private void addProduct()
    {
        // Get the ID of the product using user input
        int productId = reader.getInt("Enter the ID of the product: ");
        
        // Get the name of the product using user input
        String productName = reader.getString("Enter the name of the product: ");
        
        // Create the product and add it to the product list
        Product product = new Product(productId, productName);
        stock.add(product);
    }

    /**
     * Removes an old product from the product list
     * using user input
     */
    private void removeProduct()
    {
        // Get the product ID to remove from using user input
        int productId = reader.getInt("Enter the ID of the product to remove: ");
        
        // Try to remove the product from the product list
        stock.removeProduct(productId);
    }
    
    /**
     * Buys between 1-10 products from the product list
     * using user input
     */
    private void buyProduct()
    {
        // Get the product ID from the user
        int productID = reader.getInt("Enter the ID of the product to buy: ");

        // Get the quantity from the user
        int productQuantity = reader.getInt("Enter the quantity you would like to buy (between 1 and 10): ");

        stock.buyProduct(productID, productQuantity);
    }
    
    /**
     * Sells between 1-10 products from the product list
     * using user input
     */
    private void sellProduct()
    {
        // Get the product ID from the user
        int productID = reader.getInt("Enter the ID of the product to buy: ");

        // Get the quantity from the user
        int productQuantity = reader.getInt("Enter the quantity you would like to buy (between 1 and 10): ");

        stock.sellProduct(productID, productQuantity);
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Buy:        Buy a quantity of a product");
        System.out.println("    Sell:       Se1ll a quantity of a product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Joshua Sweeney ");
        System.out.println("********************************");
    }
}