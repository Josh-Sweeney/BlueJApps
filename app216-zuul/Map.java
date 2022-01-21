
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *             
 * @author Derek Peacock and Nicholas Day
 * @author Modified by Joshua Sweeney
 * @version 07-01-22
 */
public class Map
{
    // All the locations the player can access
    private Location park, forest, cave, townCentre, pub, bank, theatre, barber, market;

    // The current location the player is present in
    private Location currentLocation;

    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations()
    {
        // Single locations (one entrance & exit)
        createCave();
        createForest();
        createPark();
        createTheatre();
        createPub();
        createBank();
        createBarber();
        createMarket();

        // Hubs (more than one entrance & exit)
        createTownCentre();

        // Start the game in the park
        currentLocation = park;
    }

    /**
     * Create the park and link it to the
     * cave
     */
    private void createPark() {
        park = new Location("in a park in the centre of a small village. ");

        // Create the exits
        park.setExit("north", forest);
        park.setExit("west", townCentre);

        // Create the items
        park.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the forest and link it to the
     * park and cave
     */
    private void createForest() {
        forest = new Location("in a forest next to the park. There is a cave nearby. ");
        forest.setExit("south", park);
        forest.setExit("west", cave);

        // Create the items
        forest.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the cave and link it to the
     * forest
     */
    private void createCave() {
        cave = new Location("in a dark cave within the forest. ");
        cave.setExit("east", forest);

        // Create the items
        cave.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the town centre and link it
     * to the barber, bank, theatre and pub
     */
    private void createTownCentre() {
        townCentre = new Location("in the centre of the town. ");
        townCentre.setExit("north", barber);
        townCentre.setExit("north west", bank);
        townCentre.setExit("south west", theatre);
        townCentre.setExit("south", market);

        // Create the items
        townCentre.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the barber and link it to
     * the town centre
     */
    private void createBarber()
    {
        barber = new Location("in the barber shop. ");
        barber.setExit("south", townCentre);

        // Create the items
        barber.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the bank and link it to
     * the town centre
     */
    private void createBank()
    {
        bank = new Location("in the bank. ");
        bank.setExit("exit", townCentre);

        // Create the items
        bank.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the pub and link it to 
     * the town centre
     */
    private void createPub()
    {
        pub = new Location("in the pub. ");
        pub.setExit("exit", townCentre);

        // Create the items
        pub.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the market and link it to
     * the town centre
     */
    private void createMarket() {
        market = new Location("in the market of the town. ");
        market.setExit("south", townCentre);

        // Create the items
        market.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Create the theatre linked to the town centre
     */
    private void createTheatre()
    {
        theatre = new Location("in a theatre. ");
        theatre.setExit("exit", townCentre);        

        // Create the items
        theatre.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Returns the current location the player is in
     * @return The current location of the player
     */
    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}