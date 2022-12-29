

/*
 * 1. Everything user is added it adds the information to a JSON file
 * 2. loginStatus
 */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;

public class UserDatabase {

    /*
	 * Instance Variables
     */
    private User user;
    private Admin[] allAdmins;
    private User[] allUsers;
    private final int DEFAULT_USER = 100;
    private final int DEFAULT_ADMIN = 10;
    private int countUsers;
    private int countAdmin;
    public User activeUser;
    public Admin activeAdmin;
    private JSONArray fileList;
    private JSONObject usersFile;

    /*
	 * Constructors
     */
    public UserDatabase() {
        allUsers = new User[DEFAULT_USER];
        allAdmins = new Admin[DEFAULT_ADMIN];
        countUsers = 0;
        countAdmin = 0;
        activeUser = null;
        activeAdmin = null;
        this.usersFile = new JSONObject();
    }

    public UserDatabase(JSONObject file) {
        allUsers = new User[DEFAULT_USER];
        allAdmins = new Admin[DEFAULT_ADMIN];
        countUsers = 0;
        countAdmin = 0;
        activeUser = null;
        activeAdmin = null;
        this.usersFile = file;
    }

    public UserDatabase(int amount) {
        allUsers = new User[DEFAULT_USER];
        allAdmins = new Admin[DEFAULT_ADMIN];
        countUsers = 0;
        countAdmin = 0;
        activeUser = null;
        activeAdmin = null;
    }

    /*
	 * Getter Methods
     */
    public User getUser(String username) {
        JSONParser jP = new JSONParser();
        String filename = username + ".json";

        try {
            Object obj = jP.parse(new FileReader("UserDatabase/" + filename));
            JSONObject jsonObject = (JSONObject) obj;
            String un = (String) jsonObject.get("Username");
            if (un.equals("") || un == null) {
                return null;
            }
            String pw = (String) jsonObject.get("Password");
            System.out.println("Username is " + un);
            System.out.println("Password is " + pw);
            User foundUser = new User(un, pw);
            return foundUser;

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: File not found");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("I/O ErrorO");
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Parse Error");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error: unable to locate");
        }
        return null;
    }

    public Admin getAdmin(String adminname) {
        JSONParser jP = new JSONParser();
        String filename = adminname + ".json";

        try {
            Object obj = jP.parse(new FileReader("UserDatabase/" + filename));
            JSONObject jsonObject = (JSONObject) obj;
            String un = (String) jsonObject.get("Adminname");
            if (un.equals("") || un == null) {
                return null;
            }
            String pw = (String) jsonObject.get("Password");
            System.out.println("AdminName is " + un);
            System.out.println("Password is " + pw);
            Admin foundAdmin = new Admin(un, pw);
            return foundAdmin;

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: File not found");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("I/O ErrorO");
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Parse Error");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error: unable to locate");
        }
        return null;
    }

    public String displayUsers() {
        String users = "";
        for (int i = 0; i < countUsers; i++) {
            users = allUsers[i] + "\n";
        }
        return users;
    }

    public String displayAdmins() {
        String admins = "";
        for (int i = 0; i < countAdmin; i++) {
            admins = allAdmins[i] + "\n";
        }
        return admins;
    }

    /*
	 * Helper Methods
     */
    public boolean usersIsFull() {
        if (countUsers == allUsers.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean adminsIsFull() {
        if (countAdmin == allAdmins.length) {
            return true;
        } else {
            return false;
        }
    }

    /*
	 * Setter Methods
     */
    public void adminRegister(String un, String pw) {
        Admin newAdmin = new Admin(un, pw);
        /**
         * Add user to all users array
         */
        if (usersIsFull()) {
            System.out.print("Error. Cannot add user");
        } else {
            System.out.print("Adding new user: " + un);
            JSONObject usrDbFile = new JSONObject();
            JSONArray poiFavourites = new JSONArray();
            //JSONParser jsonP = new JSONParser();
            usrDbFile.put("Adminname", un);
            usrDbFile.put("Password", pw);
            usrDbFile.put("Pois", poiFavourites);
            String filename = un + ".json";
            // READ

            // WRITE
            try ( FileWriter fileWriter = new FileWriter("UserDatabase/" + filename)) {
                fileWriter.write(usrDbFile.toString());
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Could not write to file");
            }
            System.out.println("\nAdded to our file(\"" + filename + "\"):" + usrDbFile);

        }
    }

    public void adminLogin(String un, String pw) {
        System.out.println("Attemping to find admin");
        Admin findAdmin = this.getAdmin(un);
        System.out.println("Storing result\nAdmin name found: " + findAdmin);
        if (findAdmin != null) {
            System.out.println("Actual password:" + findAdmin.viewAdminPassword() + "\nUser entered:" + pw);
            if (findAdmin.viewAdminPassword().equals(pw)) {
                System.out.println("Success");
                activeUser = null;
                activeAdmin = findAdmin;
                findAdmin.login();
            } else {
                System.out.println("Password invalid");
            }
        } else {
            System.out.println("Sorry, invalid entry... no match found for admin");
        }
    }

    public void userRegister(String un, String pw) {
        User newUser = new User(un, pw);
        /**
         * Add user to all users array
         */
        if (usersIsFull()) {
            System.out.print("Error. Cannot add user");
        } else {
            System.out.print("Adding new user: " + un);
            JSONObject usrDbFile = new JSONObject();
            JSONArray poiFavourites = new JSONArray();
            //JSONParser jsonP = new JSONParser();
            usrDbFile.put("Username", un);
            usrDbFile.put("Password", pw);
            usrDbFile.put("Pois", poiFavourites);
            String filename = un + ".json";
            // READ

            // WRITE
            try ( FileWriter fileWriter = new FileWriter("UserDatabase/" + filename)) {
                fileWriter.write(usrDbFile.toString());
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Could not write to file");
            }
            System.out.println("\nAdded to our file(\"" + filename + "\"):" + usrDbFile);

        }
    }
    
    public void userLogin(String un, String pw) {
        System.out.println("Attemping to find user");
        User findUser = this.getUser(un);
        System.out.println("Storing result...\nUsername found: " + findUser);
        if (findUser != null) {
            System.out.println("Actual password:" + findUser.retrievePassword() + "\nUser entered:" + pw);
            if (findUser.retrievePassword().equals(pw)) {
                System.out.println("Success");
                activeUser = findUser;
                activeAdmin = null;
                findUser.login();
            } else {
                System.out.println("Password invalid");
            }
        } else {
            System.out.println("Sorry, invalid entry... no match found for user");
        }
    }

    public void removeUser(User user) {
        /**
         * Find index of layer to delete
         */
        int index = getUserIndex(user.viewUserName());
        if (index == -1) {
            System.out.println("Error");
        } else {
            allUsers[index] = null;
        }
        /**
         * create a temporary array to first store Layers that are not null
         * replace the original array with the temporary array
         */
        User[] tempAllUsers = new User[this.allUsers.length];
        int count = 0;
        for (int i = 0; i < this.allUsers.length; i++) {
            User current = allUsers[i];
            if (current != null) {
                tempAllUsers[count] = current;
                count++;
            }
        }
        this.allUsers = tempAllUsers;
    }

    public void removeAdmin(Admin admin) {
        /**
         * Find index of layer to delete
         */
        int index = getAdminIndex(admin.viewadminName());
        if (index == -1) {
            System.out.println("Error");
        } else {
            allAdmins[index] = null;
        }
        /**
         * create a temporary array to first store Layers that are not null
         * replace the original array with the temporary array
         */
        Admin[] tempAllAdmins = new Admin[this.allAdmins.length];
        int count = 0;
        for (int i = 0; i < this.allAdmins.length; i++) {
            Admin current = allAdmins[i];
            if (current != null) {
                tempAllAdmins[count] = current;
                count++;
            }
        }
        this.allAdmins = tempAllAdmins;
    }

    public void logout() {
        if (activeUser != null) {
            activeUser.logout();
            activeUser = null;
        } else if (activeAdmin != null) {
            activeAdmin.logout();
            activeAdmin = null;
        } else {
            System.out.println("Sorry, you are not logged in.");
        }
    }

    public int getUserIndex(String username) {
        /**
         * Return null if not found else return a User
         */
        if (countUsers > 0) {
            for (int i = 0; i < countUsers; i++) {
                User current = allUsers[i];
                if (current.viewUserName() == username) {
                    System.out.println("Found a match!");
                    return i;
                }
            }
        } else {
            System.out.println("There are no users in this database");
        }
        return -1;
    }

    public int getAdminIndex(String adminname) {
        /**
         * Return null if not found else return a User
         */
        if (countAdmin > 0) {
            for (int i = 0; i < countAdmin; i++) {
                Admin current = allAdmins[i];
                if (current.viewadminName() == adminname) {
                    System.out.println("Found a match!");
                    return i;
                }
            }
        } else {
            System.out.println("There are no users in this database");
        }

        return -1;
    }

}
