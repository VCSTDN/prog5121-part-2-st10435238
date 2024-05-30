package utils;

import main.TaskManager;
import main.UserManager;

public class ArrayController {
	
	// Method to fix the task array after removing a task
	public static void fixTaskArray(int indx) {
		// Shift tasks in the array to fill the gap left by removing a task
		for (int i = indx; i < TaskManager.count; i++) {
			TaskManager.tasks[i] = TaskManager.tasks[i+1];
		}
		// Set the last element to null and decrement the count of tasks
		TaskManager.tasks[TaskManager.count] = null;
		TaskManager.count--;
	}
	
	// Method to fix the user array after removing a user
	public static void fixUserArray(int indx) {
		// Shift users in the array to fill the gap left by removing a user
		for (int i = indx; i < UserManager.userCount; i++) {
			UserManager.users[i] = UserManager.users[i+1];
		}
		// Set the last element to null and decrement the count of users
		UserManager.users[UserManager.userCount] = null;
		UserManager.userCount--;
	}
}
