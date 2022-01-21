/**
 * This command allows the player to
 * take or pickup an item from a room
 * and carry it around to use somewhere
 * else
 *
 * @author Derek Peacock & Nicholas Day
 * @author modified by Joshua Sweeney
 * @version 21-01-22
 */
public class TakeCommand extends ZuulCommand
{
    String item;
    
    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String input)
    {
        super(zuul);
        this.item = input;
    }    

    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }

        Player player = zuul.PLAYER;
        
        // Get the current location
        Map map = zuul.MAP;
        Location currentLocation = map.getCurrentLocation();

        // Check if the requested item is in the current location
        Item itemToTake = currentLocation.getItem(this.item);
        
        if (itemToTake != null)
        {
            // Add the item to the player's inventory
            player.inventoryAdd(itemToTake);

            // Remove the item from the current location
            currentLocation.removeItem(itemToTake);

            // Print out a message to the player indicating that they took the item
            System.out.println("Took the " + this.item + ". ");
        }
        else // The item could not be found in this room
        {
            // So output a message to the player indicating that the item does
            // not exist in this room
            System.out.println("Could not find " + this.item + " in this location. ");
        }
        
        // Print the current location, items and people again
        System.out.println(currentLocation.getLongDescription());
        System.out.println(currentLocation.getItemsString());
        System.out.println(currentLocation.getPeopleString());
    }
}
