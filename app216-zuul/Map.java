
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 * 
 * @author Derek Peacock and Nicholas Day
 * @author Modified by Joshua Sweeney
 * @version 07-01-22
 */
public class Map {
    // All the locations the player can access
    private Location park, forest, cave, townCentre, pub, bank, theatre, barber, market;

    // The current location the player is present in
    private Location currentLocation;

    /**
     * Constructor for objects of class Map
     */
    public Map() {
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations() {
        // Create the locations
        park = new Location("in a park in the centre of a small village. ");
        forest = new Location("in a forest next to the park. There is a cave nearby. ");
        cave = new Location("in a dark cave within the forest. ");
        townCentre = new Location("in the centre of the town. ");
        barber = new Location("in the barber shop. ");
        bank = new Location("in the bank. ");
        pub = new Location("in the pub. ");
        market = new Location("in the market of the town. ");
        theatre = new Location("in a theatre. ");

        park.setExit("west", townCentre);

        // Setup the exits and items in each location
        setupPark();
        setupCave();
        setupForest();
        setupTheatre();
        setupPub();
        setupBank();
        setupBarber();
        setupMarket();
        setupTownCentre();

        // Start the game in the park
        currentLocation = park;
    }

    /**
     * Setup the park exits and items
     */
    private void setupPark() 
    {
        // Create the exits
        park.setExit("north", forest);
        
        // Create the items
        park.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the forest exits and items
     */
    private void setupForest()
    {
        // Create the exits
        forest.setExit("west", cave);
        forest.setExit("south", park);
        
        // Create the items
        forest.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Cave exits and items
     */
    private void setupCave()
    {
        // Create the exits
        cave.setExit("east", forest);
        
        // Create the items
        cave.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Town Centre exits and items
     */
    private void setupTownCentre()
    {
        // Create the exits
        townCentre.setExit("north", barber);
        townCentre.setExit("north-west", bank);
        townCentre.setExit("south-west", theatre);
        townCentre.setExit("south", market);

        // Create the items
        townCentre.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Barber exits and items
     */
    private void setupBarber()
    {
        // Create the exits
        barber.setExit("south", townCentre);

        // Create the items
        barber.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Bank exits and items
     */
    private void setupBank() {

        bank.setExit("exit", townCentre);

        // Create the items
        bank.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Pub exits and items
     */
    private void setupPub()
    {
        // Create the exits
        pub.setExit("exit", townCentre);

        // Create the items
        pub.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Market exits and items
     */
    private void setupMarket()
    {
        // Create the exits
        market.setExit("south", townCentre);

        // Create the items
        market.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Theatre exits and items
     */
    private void setupTheatre()
    {
        // Create the exits
        theatre.setExit("exit", townCentre);

        // Create the items
        theatre.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Returns the current location the player is in
     * 
     * @return The current location of the player
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void enterLocation(Location nextLocation) {
        currentLocation = nextLocation;
    }
}