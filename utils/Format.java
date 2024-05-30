package utils;

public class Format {

    // Method to check if username meets complexity requirements
    public static boolean checkUsernameComplexity(String username) {
        // Check if username is less than or equal to 5 characters and contains an underscore
        boolean valid = username.length() <= 5 && username.contains("_");
        return valid;
    }

    // Method to check if password meets complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        // Check if password is at least 8 characters long and contains at least one uppercase letter,
        // one lowercase letter, one digit, and one special character
        boolean valid = password.length() >= 8 
                        && password.matches(".*[A-Z].*") 
                        && password.matches(".*[a-z].*") 
                        && password.matches(".*[0-9].*") 
                        && password.matches(".*[!@#$%^&*()-_=+\\|[{]};:'\",<.>/?`~].*");
        return valid; 
    }
    public static boolean checkTaskDescription(String taskDescription) {
        // Check if the string length is less than or equal to 50
		Boolean valid = taskDescription.length() <= 50;
        return valid;
    }

    // Method to print username complexity rules
    public static void printUsernameComplexityRules() {
        System.out.println("\nUsername Must Contain:");
        System.out.println("- Less Than 5 Characters in Length");
        System.out.println("- At Least 1 Underscore\n");    
    }
    
    // Method to print password complexity rules
    public static void printPasswordComplexityRules() {
        System.out.println("\nPassword Must Contain (At Least):");
        System.out.println("- 8 Characters in Length");
        System.out.println("- 1 Special Character");
        System.out.println("- 1 Numeric Character");
        System.out.println("- 1 Upper-Case Character\n");
    }
   
	public static void printTaskDescriptionRules() {
		System.out.println("\nTask description must be:");
		System.out.println("- less than 50 Characters in Length");
	}
}
















