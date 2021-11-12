import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Joshua Sweeney
 * @version v1.0 12/11/21
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     * @param productID The id of the product to buy
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);

        if (product != null)
        {
            product.increaseQuantity(amount);
        }
        else
        {
            System.out.println("Cannot buy product with ID " + product + " as it wasn't found in the stock list. ");
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     * @param productID the ID of the product to find
     */
    public Product findProduct(int productID)
    {
        for (Product product : this.stock)
        {
            if (product.getID() == productID)
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0)
            {
                product.decreaseQuantity(1);
                
                // printout message
                System.out.println("Decreased quantity of product " + product.getName() + " by 1");
            }
            else
            {
                // printout message
                System.out.println("Product " + product.getName() + " has a quantity of 0, cannot decrease quantity. ");
            }
        }
        else
        {
            // printout message
            System.out.println("Product " + productID + "not found");
        }
    }

    /**
     * Removes a product from the stock list
     * @param productID The ID of the product to remove
     */
    public void removeProduct(int productID)
    {
        Product product = findProduct(productID);

        if (product != null)
        {
            stock.remove(product);
        }
        else
        {
            System.out.println("Cannot remove product with ID " + product + " as it doesn't exist");
        }
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);

        if (product != null)
        {
            return product.getQuantity();
        }
        else
        {
            return 0;
        }
    }

    /**
     * Prints products that contain a specific string in their name
     * @param containsName The string to find in the products name
     */
    public void printProducts(String containsName)
    {
        printHeading();
        
        System.out.println("Products containing " + containsName + ":");

        // Iterate over every product
        for (Product product : stock)
        {
            // Check if the product contains the string passed in
            if (product.getName().contains(containsName))
            {
                // Print that product by getting its ID
                printProduct(product.getID());
            }
        }
    }

    /**
     * Prints products that are below a given quantity level
     * @param belowQuantity The quantity level to check for products under
     */
    public void printProducts(int belowQuantity)
    {
        printHeading();
        
        System.out.println("Products below " + belowQuantity + " quantity: ");

        // Iterate over every product
        for (Product product : stock)
        {
            // Check if the product is below the given threshold
            if (product.getQuantity() < belowQuantity)
            {
                // Print that product by getting its ID
                printProduct(product.getID());
            }
        }
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    /**
     * Prints the heading for this stock list
     * to be used in conjunction with print()
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Sweeney's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}