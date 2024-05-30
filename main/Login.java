package main;

public class Login {
	
    // Method to prompt user for login credentials
    public static void promptLoginUser() {
        //(classwork/StudentManagementSystemDemo)
        boolean loggedIn = false;
        
        while (!loggedIn) {
            System.out.println("\nLogin for user");
            // Prompt user for username and password
            String loginUsername = Prompt.promptUserName();
    		User user = UserManager.findUserByUsername(loginUsername);
    		if (user == null) {
    			System.out.println("User Not Found - Check that your Username is correct! \n");
    			return;
    		}
            String loginPassword = Prompt.promptPassword();

            // Attempt to login with provided credentials
            boolean loginSuccess = loginUser(loginUsername, loginPassword);
            if (loginSuccess) {
            	
            	Main.current_logged_in_username = user.getUsername();
                // If login successful, display welcome message
                System.out.println("\nLogin successful!");
                
                // Find user's first and last names
                String firstName = "";
                String lastName = "";
                for (int i = 0; i < UserManager.userCount; i++) {
                    if (loginUsername.equals(UserManager.users[i].getUsername())) {
                        firstName =  UserManager.users[i].getFirstname();
                        lastName =  UserManager.users[i].getLastname();
                        break;
                    }
                }
                // Display login status and welcome message
                System.out.println(returnLoginStatus(true, firstName, lastName));
                loggedIn = true;
                // Proceed to the Kanban system
                new Kanban();
            } else {
                // If login unsuccessful, prompt user to retry or return to main menu
                System.out.println(returnLoginStatus(false, "", ""));
                System.out.print("Do you want to retry? (yes/no): ");
                String choice = Main.scanner.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("Returning to main menu...\n");
                    break;
                }
            }
        }
    }

    // Method to verify login credentials
    public static boolean loginUser(String inputUsername, String inputPassword) {
        // (Stack Overflow n.d.)
        for (int i = 0; i <  UserManager.userCount; i++) {
            if (inputUsername.equals( UserManager.users[i].getUsername()) && inputPassword.equals(UserManager.users[i].getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    // Method to return login status message
    public static String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        // classwork/StudentManagementSystemDemo
        if (loginSuccess) {
            return "\nWelcome, " + firstName + " " + lastName + "! It is great to see you again.\n";
        } else {
            return "\nUsername or password is incorrect, please try again.\n";
        }
    }    
}
