package Tests;

import static org.junit.jupiter.api.Assertions.*; // Use JUnit 5 for assertions
import org.junit.jupiter.api.Test;
import main.User;
import main.UserManager;
import main.Login;
import utils.Format;

public class LoginTest {

    // Test if the username is correctly formatted according to the rules
    @Test
    public void testUsernameCorrectlyFormatted() {
        String username = "kyl_1";
        boolean expectedValidity = true;
        boolean isValidUsername = Format.checkUsernameComplexity(username);
        assertEquals(expectedValidity, isValidUsername);
    }

    // Test if the username is not correctly formatted
    @Test
    public void testUsernameIsNotCorrectlyFormatted() {
        String username = "kyle!!!!!!!";
        boolean expectedValidity = false;
        boolean isValidUsername = Format.checkUsernameComplexity(username);
        assertEquals(expectedValidity, isValidUsername);
    }

    // Test if the password meets the complexity requirements
    @Test
    public void testPasswordMeetsTheComplexityRequirements() {
        String password = "Ch&&sec@ke99!";
        boolean expectedValidity = true;
        boolean isValidPassword = Format.checkPasswordComplexity(password);
        assertEquals(expectedValidity, isValidPassword);
    }

    // Test if the password does not meet the complexity requirements
    @Test
    public void testPasswordDoesNotMeetTheComplexityRequirements() {
        String password = "password";
        boolean expectedValidity = false;
        boolean isValidPassword = Format.checkPasswordComplexity(password);
        assertEquals(expectedValidity, isValidPassword);
    }

    // Test if the login is successful with correct credentials
    @Test
    public void testLoginSuccessful() {
        User user = new User("kyl_1", "Ch&&sec@ke99!", "asda", "asd");
        UserManager.addUser(user);
        assertTrue(Login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test if the login fails with incorrect credentials
    @Test
    public void testLoginFailed() {
        assertFalse(Login.loginUser("kyle!!!!!!!", "password"));
    }
}
