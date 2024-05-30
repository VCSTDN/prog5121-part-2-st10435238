package main;

public class Registration {
	
	public static void promptRegisterUser() {
		// Prompt user for registration
		System.out.println("\nRegistration for user");
		
		utils.Format.printUsernameComplexityRules(); // Conditions for username
		String username = Prompt.promptUserName();
		
		// Check if username already exists
		Boolean exists = checkUserName(username);
		if (exists) {
			System.out.println("Username Exists - Login/Register a New Account ... \n");
			return;
		}
		
		// Check if username format is correct
		Boolean valid_username = utils.Format.checkUsernameComplexity(username);
		if (!valid_username) {
			System.out.print("\nUsername is not correctly formatted - Ensure the Following:");
			utils.Format.printUsernameComplexityRules();
			return;
		} else {
		}
		
		utils.Format.printPasswordComplexityRules();
		String password = Prompt.promptPassword();
		
		// Check if password is a valid format 
		Boolean valid_password = utils.Format.checkPasswordComplexity(password);
		if (!valid_password) {
			System.out.print("\nPassword is not correctly formatted - Ensure the Following:");
			utils.Format.printPasswordComplexityRules();
			return;
		} else {
			System.out.println("Password successfully captured!\n");
		}
		
		String firstName = Prompt.promptFirstName(); // Accept any input
		String lastName = Prompt.promptLastName(); // Accept any input
		
		// The below will only happen if the above is correct
		// Create a new user object
		User user = new User(username, password, firstName, lastName);
		// Add the user to the user manager
		UserManager.addUser(user);
		// Print registration success message
		System.out.println("\nUser registered successfully!\n");
	}
	
	// Method to check if username is taken
	public static Boolean checkUserName(String username) {
		User user = UserManager.findUserByUsername(username);
		if (user == null) {
			return false;
		}
		return true;
	}
}
