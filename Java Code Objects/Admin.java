

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
	
	public Admin(String an, String pw)
	{
		this.adminName = an;
		this.passWord = pw;
		this.enabled = false;
		this.loggedIn = false;
	}
	
	/*
	 * Getter Methods
	 */
	public String viewadminName () {
		return this.adminName;
	}
	
        protected String viewAdminPassword () {
		return this.passWord;
	}
	
	/*
	 *  Setter Methods
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