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

    public Player(int health, int score)
    {
        this.health = health;
		this.score = score;
    }
}
