package main;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner;
	static int choice = -1;
	static String current_logged_in_username = null;
	
	public static void main(String[] args) {	
		
		// Create a scanner object to read user input
		scanner = new Scanner(System.in);
		
		// Continue displaying the menu until the user chooses to exit
		while (choice!=3) {
			// Display menu options
			Menu.showMenuOptions();
			// Prompt user for input and handle menu choices
			Menu.promptUser();
		}
		// Close the scanner object
		scanner.close();
		
	}	
}
//GeeksforGeeks. (2020). How to validate a Password using Regular Expressions in Java. [online] Available at: https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/ [Accessed 12 Apr. 2024].
//GeeksforGeeks. (2019). Java Program to check the validity of a Password using User Defined Exception. [online] Available at: https://www.geeksforgeeks.org/java-program-to-check-the-validity-of-a-password-using-user-defined-exception/[Accessed 12 Apr. 2024].
//Hombergs, T. (2022). JUnit 5 by Examples. [online] reflectoring.io. Available at: https://reflectoring.io/junit5/ [Accessed 15 Apr. 2024].
//link, G., Facebook, Twitter, Pinterest, Email and Apps, O. (n.d.). Java Scanner Tutorial | Login and Registration Console Example. [online] Available at: https://www.javaguides.net/2020/03/java-scanner-tutorial-reading-login-and-registration-user-input.html [Accessed 13 Apr. 2024].
//Mahmood (2024). password validation using boolean. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/59198059/password-validation-using-boolean [Accessed 13 Apr. 2024].
//Stack Overflow. (n.d.). Writing a program to check password for certain things. [online] Available at: https://stackoverflow.com/questions/64469827/writing-a-program-to-check-password-for-certain-things[Accessed 12 Apr. 2024].
//Stack Overflow. (n.d.). How can I change this java code so that it asks again if the password is invalid? [online] Available at: https://stackoverflow.com/questions/28156940/how-can-i-change-this-java-code-so-that-it-asks-again-if-the-password-is-invalid [Accessed 12 Apr. 2024].
//Stack Overflow. (n.d.). Input and Store names in array - Java. [online] Available at: https://stackoverflow.com/questions/47281629/input-and-store-names-in-array-java [Accessed 13 Apr. 2024].
//classwork/StudentManagementSystemDemo
