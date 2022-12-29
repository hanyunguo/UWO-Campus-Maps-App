
package com.mycompany.groupfinal;

/*
 * Notes:
 * Must be able to store favourites and POI
 * implements methods for storing favourites and POI
 * implement vairbales for favourites and POI
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
	// private Favourite[] favourites;
	
	
	/*
	 * Constructors
	 */
	
	public User (String un, String pw, String fn, String ln) {
		this.username = un;
		this.password = pw;
		this.firstName = fn;
		this.lastName = ln;
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
	
	/*
	 * Setter Methods
	 */
	
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
	
	
	
	
	
}
