import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("001", "Fix Bug", "Fix the login bug on the homepage.");
        assertEquals("001", task.getTaskId());
        assertEquals("Fix Bug", task.getName());
        assertEquals("Fix the login bug on the homepage.", task.getDescription());
    }

    @Test
    public void testInvalidTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("12345678901", "Title", "Description"));
    }

    @Test
    public void testSettersValidation() {
        Task task = new Task("002", "Title", "Description");

        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("This name is way too long for the field"));

        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This description is definitely too long to be allowed in a 50 character limit description field."));
    }
}
