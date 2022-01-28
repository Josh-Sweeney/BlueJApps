import java.time.LocalDateTime;
import java.util.Timer;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  locations, creates the CommandReader and starts the game.  
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Student Name
 */

public class Game 
{
    public final Map MAP;
    public final Player PLAYER;
    private CommandReader reader;
    private boolean gameOver;
    private int startTime; // The time the game was started
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        MAP = new Map();
        PLAYER = new Player(10, 0);
        reader = new CommandReader(this);
        startTime = LocalDateTime.now().getSecond();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        gameOver = false;

        // Enter the main command loop.  Here we repeatedly 
        // read commands and execute them until the game is over.
                
        while (! gameOver) 
        {
            gameOver = reader.getCommand();
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(" Welcome to the World of Zuul!");
        System.out.println(" World of Zuul is a new, incredibly boring adventure game.");
        System.out.println(" Type 'help' if you need help.");
        System.out.println();
        System.out.println(" Time remaining: " + (900 - getElapsedTime()) + " seconds: ");
        System.out.println(" Score: " + PLAYER.getScore());
        System.out.println(MAP.getCurrentLocation().getLongDescription());
        System.out.println(MAP.getCurrentLocation().getItemsString());
        System.out.println(MAP.getCurrentLocation().getPeopleString());
    }

    /**
     * Gets the elapsed time of the game
     */
    public int getElapsedTime()
    {
        return LocalDateTime.now().getSecond() - startTime;
    }

    /**
     * Sets the games status to game over
     */
    public void setGameOver()
    {
        this.gameOver = true;
    }
}
