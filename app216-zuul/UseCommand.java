
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
            System.out.println("Use what?");
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

        // If the item can be used in the current room
        if (currentLocation.canUseItem(this.item))
        {
            switch (item.getItemType())
            {
                // Based on the item, this code will output the a message after using the item,
                // and add the gold to the room so that the player can collect it
                case Coin:
                    System.out.println("Thanks for the coin, now you can have the gold. ");
                    map.pub.addItem(new Item("gold", ItemType.Gold));
                    break;
                case Torch:
                    System.out.println("You used the torch. Now you can see in the cave");
                    map.cave.addItem(new Item("gold", ItemType.Gold)); 
                    break;
                case Flowers:
                    System.out.println("You used the flowers. Now the bees are gone, you can collect the gold. ");
                    map.forest.addItem(new Item("gold", ItemType.Gold));
                    break;
                default:
                    break;
            }

            // Print the details of the current room
            System.out.println(" Score: " + player.getScore());
            System.out.println(map.getCurrentLocation().getLongDescription());
            System.out.println(map.getCurrentLocation().getItemsString());
            System.out.println(map.getCurrentLocation().getPeopleString());
        }
    }
}
