package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.Task;
import utils.*;
public class TaskTest {

	@Test
    public void testCheckTaskDescriptionValid() {
        String taskDescription = "Create Login to authenticate users”";
        boolean result = Format.checkTaskDescription(taskDescription);
        assertTrue(result);
    }
    @Test
    public void testCheckTaskDescriptionExceedsLimit() {
        String taskDescription = "More than 50 charcters in length test More than 50 charcters in length test More than 50 charcters in length test More than 50 charcters in length test ";
        boolean result = Format.checkTaskDescription(taskDescription);
        assertFalse(result);
    }
    
    @Test
    public void testCreateTaskID0() {
        // Arrange
        String taskName = "Login Feature";
        String developerName = "Robyn Harrison";
        Task task = new Task(taskName, "Task Description", developerName, 8.0, "To Do");
        String expectedTaskId = "LO:0:SON";
        String taskId = task.getTaskId();
        assertEquals(expectedTaskId, taskId);
    }
}
