package main;

public class AccountManager {
	
	// Enum to represent the different account management options available
	enum Items {
		RemoveAccount,
		ChangeUsername,
		ChangePassword,
		ChangeFirstName,
		ChangeLastName,
		ReturnToKanban,
	}
	
	// Constructor to display the menu items and prompt the user for input
	AccountManager () {
		showMenuItems();
		promptUserInput();
	}
	
	// Method to display the menu items to the user
	public static void showMenuItems() {
		for (int i = 0; i < Items.values().length; i++) {
			System.out.println(i + 1 + ") " + Items.values()[i]);
		}
		System.out.println("\nEnter option number: ");
	}
	
	// Method to prompt the user for input and call the appropriate method based on the user's choice
	public static void promptUserInput() {
		int choice = Main.scanner.nextInt();
		Main.scanner.nextLine(); // to flush the new-line character \n
		if (choice == 1) {
			AccountManager.removeAccount();
		} else if (choice == 2) {
			AccountManager.changeUsername();
		} else if (choice == 3) {
			AccountManager.changePassword();
		} else if (choice == 4) {
			AccountManager.changeFirstName();
		} else if (choice == 5) {
			AccountManager.changeLastName();
		} else if (choice == 6) {
			new Kanban();
		}
	}
	
	// Method to remove the user's account
	public static void removeAccount() {
	    User currentUser = User.getCurrentUser();
	    
	    System.out.print("Are you sure you want to remove your account? (yes/no): ");
	    String choice = Main.scanner.nextLine();
	    
	    if (choice.equalsIgnoreCase("yes")) {
	        System.out.print("Enter your current password to confirm account deletion: ");
	        String currentPassword = Main.scanner.nextLine();
	        
	        if (currentUser.getPassword().equals(currentPassword)) {
	            String currentUsername = currentUser.getUsername();
	            UserManager.removeUserByUsername(currentUsername);
	            System.out.println("Your account has been successfully removed.");
	        } else {
	            System.out.println("Incorrect password. Account deletion failed.");
	        }
	    } else {
	        System.out.println("Account removal cancelled.");
	    }
	}

	// Method to change the user's username
	public static void changeUsername() {
		User user = User.getCurrentUser();
	    
	    boolean passwordVerified = false;
	    while (!passwordVerified) {
	        // Prompt for current password
	        System.out.print("Enter your current password to proceed (or 'exit' to exit): ");
	        String currentPassword = Main.scanner.nextLine();
	        
	        // Check if user wants to cancel
	        if (currentPassword.equalsIgnoreCase("exit")) {
	            System.out.println("Exiting...");
	            new Kanban();
	            return; // Exit method if user cancels
	        }
	        
	        // Verify current password
	        if (user.getPassword().equals(currentPassword)) {
	            passwordVerified = true;
	        } else {
	            System.err.println("Incorrect password. Please try again.");
	        }
	    }
	    
	    utils.Format.printUsernameComplexityRules();
	    
	    boolean usernameUpdated = false;
	    while (!usernameUpdated) {
	        String new_username = Prompt.promptNewUserName();
	        boolean valid_username = utils.Format.checkUsernameComplexity(new_username);
	        
	        if (valid_username) {
	            user.setUsername(new_username);
	            System.out.println("Username successfully updated to: " + new_username);
	            usernameUpdated = true;
	        } else {
	            System.err.print("Username not updated!\n");
	            System.out.print("\nUsername is not correctly formatted - Ensure the Following:");
				utils.Format.printUsernameComplexityRules();
	            
	            System.out.print("Do you want to retry? (yes/no): ");
	            String choice = Main.scanner.nextLine();
	            if (!choice.equalsIgnoreCase("yes")) {	
	                System.out.println("\nReturning to Kanban...");
	                new Kanban();
	                return; // exit method if user chooses not to retry
	            }
	        }
	    }
	}
	
	// Method to change the user's password
	public static void changePassword() {
		User user = User.getCurrentUser();
	    
	    boolean passwordVerified = false;
	    while (!passwordVerified) {
	        // Prompt for current password
	        System.out.print("Enter your current password to proceed (or 'exit' to exit): ");
	        String currentPassword = Main.scanner.nextLine();
	        // Check if user wants to cancel
	        if (currentPassword.equalsIgnoreCase("exit")) {
	            System.out.println("Exiting...");
	            new Kanban();
	            return;
	        }
	        // Verify current password
	        if (user.getPassword().equals(currentPassword)) {
	            passwordVerified = true;
	        } else {
	            System.err.println("Incorrect password. Please try again.");
	        }
	    }
	    
	    utils.Format.printPasswordComplexityRules();
	    
	    boolean passwordUpdated = false;
	    
	    while (!passwordUpdated) {
	        String new_password = Prompt.promptNewPassword();
	        boolean valid_password = utils.Format.checkPasswordComplexity(new_password);
	        
	        if (valid_password) {
	            user.setPassword(new_password);
	            System.out.println("Password successfully updated!\n");
	            passwordUpdated = true;
	        } else {
	            System.err.print("Password not updated!\n");
	            
	            System.out.print("\nPassword is not correctly formatted - Ensure the Following:");
	            utils.Format.printPasswordComplexityRules();
	            
	            System.out.print("Do you want to retry? (yes/no): ");
	            String choice = Main.scanner.nextLine();
	            
	            if (!choice.equalsIgnoreCase("yes")) {
	                System.out.println("\nReturning to Kanban...\n");
	                new Kanban();
	                return; 
	            }
	        }
	    }
	}

	// Method to change the user's first name
	public static void changeFirstName() {
		User user = User.getCurrentUser();
		System.out.print("Enter your new first name: ");
	    String newFirstName = Main.scanner.nextLine();
	    
	    user.setFirstname(newFirstName);
	    System.out.println("First name successfully updated to: " + newFirstName);
	}

	// Method to change the user's last name
	public static void changeLastName() {
		User user = User.getCurrentUser();
		System.out.print("Enter your new last name: ");
	    String newLastName = Main.scanner.nextLine();
	    
	    user.setLastname(newLastName);
	    System.out.println("Last name successfully updated to: " + newLastName);
	}
}
