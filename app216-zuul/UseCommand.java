
/**
 * This command allows the player to
 * use an item from their inventory
 *
 * @author Joshua Sweeney
 * @version 07-01-22
 */
public class UseCommand extends ZuulCommand
{
    // The item to use
    String item;
    
    /**
     * Use an item from a the player's inventory
     * and remove it from the player's inventory
     */
    public UseCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
    }    

    /**
     * Execute the command to use an item
     */
    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }

        // Find the item in the inventory
        Player player = zuul.PLAYER;
        Item item = player.findInventoryItem(this.item);

        // If the item doesn't exist, notify the player
        if (item == null)
        {
            System.out.println("You don't have this item.");
        }

        // Get the current location
        Map map = zuul.MAP;
        Location currentLocation = map.getCurrentLocation();

        // Check if the item can be used in the current room
        if (item.canUseItem(currentLocation) == false)
            return;

        switch (item.getItemType())
        {
            case Coin:
                break;
            case Torch:
                break;
            default:
                break;
        }
    }
}
