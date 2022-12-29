

/*
 * Notes:
 * Must be able to store favourites and POI
 * IMPLEMENT REMOVE FAVOURITE
 */

/*
 * The User class stores information for a singular general user with restricted 
 * permissions in the application. A user will have a first name, last name, username and password. They will be able to access Buildings, Points of Interest (POI) and Maps; but users will not be able to modify build-in data by the Administrator.
 * Responsibility:					Collaborator:
 * Marked POI as favourite			User
 * Unmarked POI as favourite		User
 * Create user-defined POI			User
 * Modify user-defined POI			User 
 */


public class User {
	
	/*
	 * Instance Variables
	 */
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean enabled;
	private boolean loggedIn;
        private Poi[] favourites;
        private final int MAX_FAV = 10;
        private int countFav;
	// private Favourite[] favourites;
	
	
	/*
	 * Constructors
	 */
	
	public User (String un, String pw, String fn, String ln) {
		this.username = un;
		this.password = pw;
		this.firstName = fn;
		this.lastName = ln;
                this.favourites = new Poi[MAX_FAV];
                this.countFav = 0;
		/**
		 * A user is disabled when created. The account must be enabled 
		 */
		this.enabled = false;
		this.loggedIn = false;
	}
	
	public User (String un, String pw) {
		this.username = un;
		this.password = pw;
		this.firstName = "";
		this.lastName = "";
                this.favourites = new Poi[MAX_FAV];
                this.countFav = 0;
		/**
		 * A user is disabled when created. The account must be enabled 
		 */
		this.enabled = false;
		this.loggedIn = false;
	}
	
	/*
	 * Getter Methods
	 */
	public String viewUserName () {
		return this.username;
	}
	
	public String viewFirstName () {
		return this.firstName;
	}
	
	public String viewLastName () {
		return this.lastName;
	}
	
	protected String retrievePassword () {
		return this.password;
	}
        public String viewAllFavourites (){
            String allFav = "";
            for (int i=0; i<countFav; i++) {
                allFav += favourites[i] + "\n";
            }
            return allFav;
        }
        
        public Poi selectFavouriteByName (String poiName){
            for (int i=0; i<countFav; i++) {
                Poi currentPoi = favourites[i];
                if (currentPoi.getName().equals(poiName)){
                    return currentPoi;
                }
            }
            return null;
        }
	
	/*
	 * Setter Methods
	 */
	
        public void addFavourite (Poi newFavouritePoi) {
            if (!this.isFull()) {
                favourites[countFav] = newFavouritePoi;
                countFav++;
            }
            else {
                System.out.println("Error. Reached maximum of: " + MAX_FAV);
            }
        }
        
	/* ENABLE */
	public void enable () {
		enabled = true;
	}
	
	public void disable () {
		enabled = false;
	}
	
	public void login ()
	{
		this.loggedIn = true;
	}
	
	public void logout () {
		this.loggedIn = false;
	}
	
	/*USER INFO*/
	public void changePassword (String pw) {
		this.password = pw;
	}
	
	public void changeFirstName (String fn) {
		this.firstName = fn;
	}
	
	public void changeLastName (String ln) {
		this.lastName = ln;
	}
        
        /*Helper*/
        
        private boolean isFull (){
            return (countFav >= MAX_FAV);
        }
	
}