import java.util.ArrayList;

/**
 * Represents an item that the player can collect and use
 * @author Joshua Sweeney
 * @version 07-01-22
 */
public class Item
{
	// Type of item
	private ItemType type;

	// Name of item
	private String name;

	// List of rooms where this item can be used
	private ArrayList<String> useLocations;

	/**
	 * Creates a new item using a name and
	 * type of item
	 */
	Item(String name, ItemType type, ArrayList<String> useLocations)
	{
		this.name = name;
		this.type = type;
		this.useLocations = useLocations;
	}

	/**
	 * Gets and returns the current name of
	 * this item
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Gets and returns the current item
	 * type
	 */
	public ItemType getItemType()
	{
		return this.type;
	}

	/**
	 * Checks if this item can be used in the
	 * current room
	 * @param room The room to check where the
	 * item can be used in
	 * @return status indicating if the item
	 * can be used in this room
	 */
	public boolean canUseItem(String room)
	{
		return this.useLocations.contains(room);
	}
}