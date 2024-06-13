package main;

public class User {
	// (Used Ice task 5 & StudentManagementSystemDemo)
	// Variables
	private String _username;
	private String _password;
	private String _firstname;
	private String _lastname;
	
	// Constructor
	public User(String username, String password, String firstname, String lastname) {
		_username = username;
		_password = password;
		_firstname = firstname;
		_lastname = lastname;
	}
	
	// Setter and Getter methods for user name
	public void setUsername(String username) {
		_username = username;
	}	
	public String getUsername() {
		return _username;
	}
	
	// Setter and Getter methods for password
	public void setPassword(String password) {
		// validate new password format before capture
		_password = password;
	}
	public String getPassword() {
		return _password;
	}
	
	// Setter and Getter methods for first name
	public void setFirstname(String firstname) {
		_firstname = firstname;
	}
	public String getFirstname() {
		return _firstname;
	}
	
	// Setter and Getter methods for last name
	public void setLastname(String lastname) {
		_lastname = lastname;
	}
	public String getLastname() {
		return _lastname;
	}
	
	public void setSurname(String lastname) {
		setLastname(lastname);
	}
	public String getSurname() {
		return getLastname();
	}
	
	// Getter for current user used in AccountManager
	public static User getCurrentUser() {
	    String currentUsername = Main.current_logged_in_username;
	    System.out.println("Current Username: " + currentUsername);
	    return UserManager.findUserByUsername(currentUsername);
	}

	public void printUser() {
		System.out.print
		(
		   _username + " " +
		   _password + " " +
		   _firstname + " " +
		   _lastname + "\n" 
	   );
	}
	
}