/**
 * This class provides functionality to provide help
 * to the player about how to play the game and
 * how to use the commands
 *
 * @author Joshua Sweeney
 * @version 21-01-22
 */
public class HelpCommand extends ZuulCommand
{
    public HelpCommand(Game zuul)
    {
        super(zuul);
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and
     * a list of the command words.
     */
    public void execute()
    {
        System.out.println(" You find yourself in a park");
        System.out.println(" in the centre of a small town.");        
        System.out.println();
        System.out.println(" Your command words are:");
        System.out.println();
        
        for(CommandWords command : CommandWords.values())
        {
            System.out.println(" " + command.word + 
                               "\t  : " + command.description);                        
        }   
        System.out.println();
        System.out.println(" e.g. go west, take gold");
        System.out.println();
        System.out.println(zuul.MAP.getCurrentLocation().getLongDescription());
    }
}
