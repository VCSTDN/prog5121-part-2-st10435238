package main;

public class UserManager {
	
	public static int userCount = 0;
	public static User[] users = new User[100];
	
	static public void addUser(User user) {
		users[userCount] = user;
		userCount++;
	}
	
	public static User findUserByUsername(String username) {
		for (int i = 0; i < userCount; i++) {
			User currentUser = users[i];
			String currentUserName = currentUser.getUsername(); 
			if (currentUserName.equals(username)) {
				return currentUser;
			}
		}
		return null;
	}
	
	public static User findUserByFirstname(String firstname) {
		for (int i = 0; i < userCount; i++) {
			User currentUser = users[i];
			String currentUserName = currentUser.getFirstname(); 
			if (currentUserName.equals(firstname)) {
				return currentUser;
			}
		}
		return null;
	}
	
	public static User findUserByLastName(String lastname) {
		for (int i = 0; i < userCount; i++) {
			User currentUser = users[i];
			String currentUserName = currentUser.getLastname(); 
			if (currentUserName.equals(lastname)) {
				return currentUser;
			}
		}
		return null;
	}	
	
	public static void printUsers() {
		System.out.println("All Users: \n");
		for (int i = 0; i < userCount;  i++) {
			users[i].printUser();
		}
	}

	static public void removeUserByUsername(String username) {
		System.out.println(username);
		User userToRemove = findUserByUsername(username);
		int indx = findUserIndexByUserName(username);
		// check if user & index are valid
		if (userToRemove != null && indx != -1) {
			userToRemove = null;
			utils.ArrayController.fixUserArray(indx);
		}
		Task[] tasks = TaskManager.tasks;
		for (int i = 0; i < TaskManager.count; i++) {
			tasks[i].removeUserFromTask(username);
		}
	}
	
	private static int findUserIndexByUserName(String username) {
		for (int i = 0; i < UserManager.userCount; i++) {
			if (UserManager.users[i].getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}
	
}