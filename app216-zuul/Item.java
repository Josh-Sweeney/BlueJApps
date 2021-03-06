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

	/**
	 * Creates a new item using a name and
	 * type of item
	 */
	Item(String name, ItemType type)
	{
		this.name = name;
		this.type = type;
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
}