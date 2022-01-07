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
	public int health;

	// Score
	public int score;

	// Inventory
	public ArrayList<Item> inventory;

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
}
