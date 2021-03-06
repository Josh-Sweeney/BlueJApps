import java.util.ArrayList;
/**
 * Represents a player 
 *
 * @author Joshua Sweeney
 * @version 07-01-22
 */
public class Player
{
    // Health
    private int health;

    // Score
    private int score;

    // Status
    private String status;

    // Inventory
    private ArrayList<Item> inventory;

    /**
     * Creates a new player with an initial
     * health and score
     * @param health the initial health of the
     * player
     * @param score the initial score of the 
     * plaer
     */
    public Player(int health, int score)
    {
        this.health = health;
        this.score = score;
        inventory = new ArrayList<Item>();
    }

    /**
     * Attempts to find an item from the player's
     * inventory based on its name
     * @param name the name of the item to search
     * for
     * @return the found item. If not found null
     * is returned
     */
    public Item findInventoryItem(String name)
    {
        // Iterate over every item in the inventory
        for (Item item : this.inventory)
        {
            // Return the current item if the name matches
            if (item.getName().equals(name))
            {		
                return item;
            }
        }

        // If not found, return null
        return null;
    }

    /**
     * Adds an item to the current player's inventory
     * @param item The item to add to the inventory
     */
    public void inventoryAdd(Item item) 
    {
        this.inventory.add(item);
    }

    /**
     * Returns the player's score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Increments the players score counter by the given amount
     * @param score The amount to increase the score by
     */
    public void addScore(int score)
    {
        this.score += score;
    }

    /**
     * Updates the status of the player
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
