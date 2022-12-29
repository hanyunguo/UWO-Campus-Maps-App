package com.mycompany.groupfinal;

/*
 * 1. Everything user is added it adds the information to a JSON file
 * 2. loginStatus
 */

public class UserDatabase {
	
	/*
	 * Instance Variables
	 */
	
	private User user;
	private Admin admin;
	private User[] allUsers;
	private Admin[] allAdmins;
	private final int DEFAULT = 100;
	private int countUsers;
	private int countAdmin;
	public User activeUser;
	public Admin activeAdmin;
	
	/*
	 * Constructors
	 */
	
	public UserDatabase () {
		allUsers = new User[DEFAULT];
		allAdmins = new Admin[DEFAULT];
		countUsers = 0;
		countAdmin = 0;
		activeUser = null;
		activeAdmin = null;
	}
	
	public UserDatabase (int amount) {
		allUsers = new User[amount];
		allAdmins = new Admin[amount];
		countUsers = 0;
		countAdmin = 0;
		activeUser = null;
		activeAdmin = null;
	}
	
	/*
	 * Getter Methods
	 */
	public User getUser (String username) {
		/**
		 * Return null if not found else return a User
		 */
		if (countUsers > 0) {
			for (int i=0;i<countUsers;i++) {
				User current = allUsers[i];
				if (current.viewUserName() == username)
				{
					System.out.println("Found a match!");
					return current;
				}
			}
		}
		else
		{
			System.out.println("There are no users in this database");
		}
		
		return null;
	}
	
	public Admin getAdmin (String username) {
		/**
		 * Return null if not found else return a User
		 */
		if (countAdmin > 0) {
			for (int i=0;i<countAdmin;i++) {
				Admin current = allAdmins[i];
				if (current.viewadminName() == username)
				{
					System.out.println("Found a match!");
					return current;
				}
			}
		}
		else
		{
			System.out.println("There are no users in this database");
		}
		
		return null;
	}
	
	/*
	 * Helper Methods
	 */
	
	public boolean userisFull () {
		if (countUsers >= allUsers.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean adminisFull () {
		if (countAdmin >= allAdmins.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * Setter Methods
	 */
	
	public void registerUser (String un, String pw) {
		User newUser = new User(un, pw);
		/**
		 * Add user to allusers array
		 */
		if (userisFull()) {
			System.out.print("Error. Cannot add user");
		}
		else {
			System.out.print("Adding new user: " + un);
			allUsers[countUsers] = newUser;
			countUsers ++; 
		}
	}
	
	public void registerAdmin (String un, String pw) {
		Admin newAdmin = new Admin(un, pw);
		/**
		 * Add user to allusers array
		 */
		if (adminisFull()) {
			System.out.print("Error. Cannot add admin");
		}
		else {
			System.out.print("Adding new user: " + un);
			allAdmins[countAdmin] = newAdmin;
			countAdmin ++; 
		}
	}
	
	public void login (String un, String pw) {
		User findUser = this.getUser(un);
		Admin findAdmin = this.getAdmin(un);
		
		if (findUser != null || findUser.retrievePassword() == pw) {
			System.out.println("Success");
			activeUser = findUser;
			activeAdmin = null;
			findUser.login();
		}
		else if (findAdmin != null || findAdmin.viewadminPassword() == pw) {
			System.out.println("Success");
			activeAdmin = findAdmin;
			activeUser = null;
			findAdmin.login();
		}
		else {
			System.out.println("Sorry, invalid entry.");
		}
	}
	
	public void logout () {
		if (activeUser != null) {
			activeUser.logout();
			activeUser = null;
		}
		else if (activeAdmin != null) {
			activeAdmin.logout();
			activeAdmin = null;
		}
		else {
			System.out.println("Sorry, you are not logged in.");
		}
	}
	

}
