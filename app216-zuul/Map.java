
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
		createTheatre();
		createPub();
		createBank();
		createBarber();
		createMarket();

		// Hubs (more than one entrance & exit)
        createPark();
		createForest();
		createTownCentre();
		
		// Start the game in the park
        currentLocation = park;
    }

	/**
	 * Create the park and link it to the
	 * cave
	 */
	private void createPark() {
		park = new Location("A park in the centre of a small village");
		park.setExit("north", forest);
		park.setExit("west", townCentre);
	}

	/**
	 * Create the forest and link it to the
	 * park and cave
	 */
	private void createForest() {
		forest = new Location("A forest next to the park. There is a cave nearby");
		forest.setExit("south", park);
		forest.setExit("west", cave);
	}
	
	/**
	 * Create the cave and link it to the
	 * forest
	 */
	private void createCave() {
		cave = new Location("A dark cave within the forest");
		cave.setExit("east", forest);
	}

	/**
	 * Create the town centre and link it
	 * to the barber, bank, theatre and pub
	 */
	private void createTownCentre() {
		townCentre = new Location("The centre of the town");
		townCentre.setExit("Barber", barber);
		townCentre.setExit("Bank", bank);
		townCentre.setExit("Theatre", theatre);
		townCentre.setExit("Barber", barber);
	}
	
	/**
	 * Create the barber and link it to
	 * the town centre
	 */
	private void createBarber() {
		barber = new Location("The barber shop");
		barber.setExit("exit", townCentre);
	}
	
	/**
	 * Create the bank and link it to
	 * the town centre
	 */
	private void createBank() {
		bank = new Location("The bank");
		bank.setExit("exit", townCentre);
	}
	
    /**
	 * Create the pub and link it to 
	 * the town centre
     */
	private void createPub()
    {
		pub = new Location("The pub");
        pub.setExit("exit", townCentre);
    }
	
	/**
	 * Create the market and link it to
	 * the town centre
	 */
	private void createMarket() {
		market = new Location("The market of the town");
		market.setExit("south", townCentre);
	}
    
    /**
	 * Create the theatre linked to the outside
     */
	private void createTheatre()
    {
		theatre = new Location("in a theatre");
		theatre.setExit("exit", townCentre);        
    }
        
    public Location getCurrentLocation()
    {
        return currentLocation;
    }
    
    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}