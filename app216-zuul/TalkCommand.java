
/**
 * This command allows the player to
 * talk to a vendor at the market
 *
 * @author Joshua Sweeney
 * @version 07-01-22
 */
public class TalkCommand extends ZuulCommand
{
    // The person to talk to
    String person;
    
    /**
     * Talks to a person from the market
     * to give hints about the game objective
     */
    public TalkCommand(Game zuul, String person)
    {
        super(zuul);
        this.person = person;
    }    

    /**
     * Execute the command to talk to a person
     */
    public void execute()
    {
        if (this.person == null) 
        {
            // if there is no second word, we don't know who to talk to...
            System.out.println("Talk to who?");
            return;
        }

        switch (this.person)
        {
            case "Butcher":
                break;
            case "Greengrocer":
                break;
            default:
                break;
        }
    }
}
