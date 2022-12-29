

/*
 * Notes:
 * 
 */

/*
 * The Admin class stores information for a singular Administration user with access to the 
 * System's Editing Tools. An administrator will have a admin name and password.

Responsibility:											Collaborator:
Access Editing Tools									Administrator
Add data to the System Database							Administrator
Remove data from the System Database					Administrator
Modify data in the System Database						Administrator
Add users to the User Database							Administrator
Remove users from the User Database						Administrator
Modify user information inside the User Database		Administrator
 */
/**
 * <b>Admin </b>The Admin class stores information for a singular Administration user with access to the system's Editing Tools.
 * <p>
 * An administrator will have a admin name and password.
 * </p>
 * @author Team 12
 */
public class Admin {

	/*
	 * Instance Variables
	 */
	
	private String adminName;
	private String passWord;
	private boolean enabled;
	private boolean loggedIn;
	
	/*
	 * Constructors
	 */
	
        /**
         * Get admin name and password to login
         * @param an
         * @param pw 
         */
	public Admin(String an, String pw)
	{
		this.adminName = an;
		this.passWord = pw;
		this.enabled = false;
		this.loggedIn = false;
	}
	

        /**
         * Getter Methods to view admin name
         * @return admin's name
         */
	public String viewadminName () {
		return this.adminName;
	}
	/**
         * Getter Methods to view admin password
         * @return admin's password
         */
        protected String viewAdminPassword () {
		return this.passWord;
	}
	
        /**
         * Setter Methods
         * Change admin's password
         * @param pw 
         */
        public void changeAdminPassword (String pw){
            this.passWord = pw;
        }
        
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
}