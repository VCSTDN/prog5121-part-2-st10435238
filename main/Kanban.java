package main;

public class Kanban {
	
	enum Items {
		ManageTasks,
		ManageAccount,
		ReturnToMainMenu
	}
	
	Kanban() {
		showKanbanMenu();
		int choice = promptUserChoice();
		if (choice == 1) {
			System.out.println("\nManage tasks\n");
			TaskManager.showTaskManagerMenuItems();
			TaskManager.promptUser();
		} else if (choice == 2) {
			// Manage User Personal Account
			System.out.println("\nManage accounts\n");
			new AccountManager();
		} else if (choice == 3) {
			// Do Nothing
			System.out.println("Returning to main menu...\n");
		} else {
			// If the program reaches this point, then the user chose an invalid option
			System.out.println("Invalid Choice - Try Again? \n");
			// Request user to choose a correct option
			new Kanban();
		}
	}
	
	private static void showKanbanMenu() {
		System.out.println("Kanban Menu: \n");
		for (int i = 0; i < Items.values().length; i++) {
			System.out.println(i + 1 + ") " + Items.values()[i]);
		}
		System.out.println("\nEnter option number: ");
	}
	
	private static int promptUserChoice() {
		int choice = Main.scanner.nextInt();
		Main.scanner.nextLine();
		return choice;
	}
	
}