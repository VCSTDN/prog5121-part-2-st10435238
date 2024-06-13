package main;

public class Task {
    private static int taskCounter = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerName;
    private double taskDuration;
    private String taskId;
    private String taskStatus;

    public int countTeamMembers = 0; // keep track number of team members;
	public User[] teamMembers = new User[100]; // a list of User objects that are responsible for this task

    public Task(String taskName, String taskDescription, String developerName, double taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskId = createTaskID();
    }

    private String createTaskID() {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String devInitials = developerName.substring(developerName.length() - 3).toUpperCase();
        return String.format("%s:%d:%s", taskInitials, taskNumber, devInitials);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
        this.taskId = createTaskID(); // Update taskId when taskName changes
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription.length() > 50) {
            throw new IllegalArgumentException("Please enter a task description of less than 50 characters");
        }
        this.taskDescription = taskDescription;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
        this.taskId = createTaskID(); // Update taskId when developerName changes
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void removeUserFromTask(String username) {
		for (int i = 0; i < this.countTeamMembers; i++) {
			if (this.teamMembers[i].getUsername().equals(username) ) {
				System.out.println("Remove " + username);
				teamMembers[i] = null;
			}
		}
		this.removeNullUsersFromTasks();
	}
	
	public void removeNullUsersFromTasks() {
		// iterate all tasks and remove any null tasks 
		for (int i = 0; i < TaskManager.count; i++) {
			if (TaskManager.tasks[i] == null && i < TaskManager.count) {
				TaskManager.tasks[i] = TaskManager.tasks[i+1];
			}
		}
		TaskManager.tasks[TaskManager.count] = null;
		this.countTeamMembers--;
	}
}
