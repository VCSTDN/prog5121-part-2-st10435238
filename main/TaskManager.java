package main;

public class TaskManager {
    // Array to store tasks
    public static Task[] tasks = new Task[100];
    // Count of tasks
    public static int count = 0;

    // Enum to represent task manager menu items
    enum Items {
        AddTask,
        ShowReport,
        ReturnToMainMenu,
    }

    // Method to display task manager menu items
    public static void showTaskManagerMenuItems() {
        System.out.println("\nTask Manager Menu: \n");
        for (int i = 0; i < Items.values().length; i++) {
            System.out.println(i + 1 + ") " + Items.values()[i]);
        }
    }

    // Method to prompt user for menu choice
    public static void promptUser() {
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();
        if (choice == 1) {
            TaskManager.createTasks();
        } else if (choice == 2) {
            TaskManager.showTaskReport();
            new Kanban();
        } else if (choice == 3) {
            System.out.println("Returning to main menu...\n");
            new Kanban();
        } else {
            System.out.println("Invalid Choice - Try Again? \n");
            new Kanban();
        }
    }

    // Method to create a new task
    public static Task createNewTask() {
        String taskName = Prompt.promptTaskName();

        // Prompt user for task description
        utils.Format.printTaskDescriptionRules();
        String taskDescription = Prompt.promptTaskDescription();

        if (taskDescription.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters");
            return null;
        } else {
            System.out.println("Description successfully captured!\n");
        }

        // Prompt user for developer name
        String developerName = Prompt.promptFirstName() + " " + Prompt.promptLastName();

        // Prompt user for task duration
        double taskDuration = Prompt.promptHour();
        
        Main.scanner.nextLine(); // Consume newline character
        // Prompt user for task status
        System.out.println("Choose task status:");
        System.out.println("1. To do");
        System.out.println("2. Done");
        System.out.println("3. Doing");
        String taskStatus = Main.scanner.nextLine();
        switch (taskStatus) {
            case "1":
                taskStatus = "To Do";
                break;
            case "2":
                taskStatus = "Done";
                break;
            case "3":
                taskStatus = "Doing";
                break;
            default:
                System.out.println("Invalid choice");
                return null;
        }

        // Create new task object
        Task task = new Task(taskName, taskDescription, developerName, taskDuration, taskStatus);
        // Add task to array
        tasks[count] = task;
        // Increment count of tasks
        count++;
		return task;
		
    }

    // Method to create multiple tasks
    public static void createTasks() {
        // Prompt user for number of tasks
        int n = promptUserForNumberOfTasks();
        // Loop to create n tasks
        int i = 0;
        while (i < n) {
            System.out.println("Task " + i);
            Task task = TaskManager.createNewTask();
            if (task == null) {
                System.out.println("Task creation interrupted. Exiting...");
                break;
            }
            i++;
        }
        TaskManager.showTaskManagerMenuItems();
		TaskManager.promptUser();
    }

    // Method to display task report
    public static void showTaskReport() {
        System.out.println("\nTask Report:");
        // Loop through tasks and print details
        for (int i = 0; i < count; i++) {
            Task task = tasks[i];
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Task Description: " + task.getTaskDescription());
            System.out.println("Developer Name: " + task.getDeveloperName());
            System.out.println("Task Duration: " + task.getTaskDuration());
            System.out.println("Task Status: " + task.getTaskStatus());
            System.out.println();
        }
    }

    // Method to prompt user for number of tasks
    public static int promptUserForNumberOfTasks() {
        System.out.print("Enter the Number of Tasks to Capture: ");
        int n = Main.scanner.nextInt();
        Main.scanner.nextLine();
        return n;
    }

    // Method to prompt user for task status
    static int promptTaskStatus() {
        System.out.print("Enter Task Status (To-Do: -1; In-Progress: 0; Complete: 1): ");
        int status = Main.scanner.nextInt();
        Main.scanner.nextLine();
        return status;
    }
}
