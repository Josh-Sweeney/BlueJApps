import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Location - a location on the map of an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Location" represents one place in the scenery of the game.  It is 
 * connected to other locations via exits.  For each existing exit, the 
 * location stores a reference to the neighboring locations.
 * 
 * @author  Michael Kölling and David J. Barnes
 * Modified by Derek Peacock & Nicholas Day
 * @version 2016.02.29
 */

public class Location 
{
    // The description of this location
    private String description;

    // Stores the exits of this location
    private HashMap<String, Location> exits;

    // Stores the items available in this location
    private HashMap<String, Item> items;


    /**
     * Create a location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        this.items = new HashMap<>();
    /**
     * Adds an item to the list of items available
     * in this location
     */
    public void addItem(Item item)
    {
        this.items.put(item.getName(), item);
    }

    /**
     * Gets an item from the list of items in this location
     * and returns the result
     * @param itemName The name of the item to find
     * @return The item if found. Null if the item
     * was not found
     */
    public Item getItem(String itemName)
    {
        return this.items.get(itemName);
    }

    /**
     * Removes the requested item from the list of
     * items in this room
     * @param item The item to remove from this room
     */
    public void removeItem(Item item)
    {
        this.items.remove(item.getName());
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return " You are " + description + ".\n" + getExitString();
    }

    /**
     * Returns the items that are available in this area
     * in the format:
     *      Items: item1, item2...
     * @return A list of items in this location
     */
    public String getItemsString()
    {
        // Return a message if there are no items in this room
        if (this.items.isEmpty())
        {
            return "There are no items in this area. ";
        }

        String output = "Items: ";

        // Iterate over the keys of the items hashmap (names)
        for (String itemName : items.keySet())
        {
            // Append the item name to the message
            output += itemName;
        }

        // Return the final output
        return output;
    }

    /**
     * Return a string describing the locations's exits, 
     * for example "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = " Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
}

