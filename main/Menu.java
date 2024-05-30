package main;
public class Menu {

	// Enum for menu items
	enum Items {
		//(classwork/StudentManagementSystemDemo)
		Registration,
		Login,
		Exit,
	}
	
	// Method to display menu options
	public static void showMenuOptions() {
		//(classwork/StudentManagementSystemDemo)
        System.out.println("Please select one of the following options:\n");
		for (int i = 0;i  < Items.values().length; i++) {
			System.out.println(i + 1 + ") " + Items.values()[i]);
		}
		System.out.println("\nEnter option number: ");
	}
	
	// Method to prompt user for input and handle menu choices
	public static void promptUser() {
		// Read user input
		int choice = Main.scanner.nextInt();
		Main.scanner.nextLine();  // Consume newline left-over
		
		Main.choice = choice;
		
		// Handle menu choices
		if (choice == 1) {
			Registration.promptRegisterUser();
		} else if (choice == 2) {
			Login.promptLoginUser();
		} else if (choice == 3) {
			// Do Nothing
			System.out.println("\nTerminating Program!\n");
		} else {
			// Do Nothing 
			System.out.println("\nInvalid Option Selected - Try Again?\n");			
		}
		
	}
	
}
