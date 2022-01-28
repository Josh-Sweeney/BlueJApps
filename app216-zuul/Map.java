
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
    public Location park, forest, cave, townCentre, pub, bank, theatre, barber, market;

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
        forest = new Location("in a forest next to the park. There is a cave nearby. There is a bee hive near something interesting...");
        cave = new Location("in a dark cave within the forest. You cannot see anything. ");
        townCentre = new Location("in the centre of the town. ");
        barber = new Location("in the barber shop. The barber seems to want something... ");
        bank = new Location("in the bank. ");
        pub = new Location("in the pub. ");
        market = new Location("in the market of the town. ");
        theatre = new Location("in a theatre. ");

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
        park.setExit("west", townCentre);
        
        // Create the items
        park.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the forest exits and items
     */
    private void setupForest()
    {
        // Create the exits
        forest.setExit("east", cave);
        forest.setExit("south", park);

        // Add the items that can be used in this location
        forest.addUseItem(new Item("flowers", ItemType.Flowers));
    }

    /**
     * Setup the Cave exits and items
     */
    private void setupCave()
    {
        // Create the exits
        cave.setExit("west", forest);

        // Add the items that can be used in this location
        cave.addUseItem(new Item("torch", ItemType.Torch));
    }

    /**
     * Setup the Town Centre exits and items
     */
    private void setupTownCentre()
    {
        // Create the exits
        townCentre.setExit("north", barber);
        townCentre.setExit("north-west", bank);
        townCentre.setExit("west", pub);
        townCentre.setExit("south-west", theatre);
        townCentre.setExit("south", market);
        townCentre.setExit("east", park);

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

        // Create the people
        barber.addPerson("barber", "Give me a coin for this gold. ");
    }

    /**
     * Setup the Bank exits and items
     */
    private void setupBank() {

        bank.setExit("south-east", townCentre);

        // Create the items
        pub.addItem(new Item("coin", ItemType.Coin));

        // Create the items
        bank.addItem(new Item("gold", ItemType.Gold));
    }

    /**
     * Setup the Pub exits and items
     */
    private void setupPub()
    {
        // Create the exits
        pub.setExit("east", townCentre);
        
        // Create the people
        pub.addPerson("", "If you give me a coin, I will let you take the gold. ");
    }

    /**
     * Setup the Market exits and items
     */
    private void setupMarket()
    {
        // Create the exits
        market.setExit("north", townCentre);

        // Create the items
        market.addItem(new Item("gold", ItemType.Gold));
        market.addItem(new Item("flowers", ItemType.Flowers));
        market.addItem(new Item("torch", ItemType.Torch));

        // Create the people
        market.addPerson("flower salesman", "You can take these flowers. ");
        market.addPerson("torch salesman", "You can take this torch. ");
    }

    /**
     * Setup the Theatre exits and items
     */
    private void setupTheatre()
    {
        // Create the exits
        theatre.setExit("north-east", townCentre);

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