import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService service;
    private Task task;

    @BeforeEach
    public void setUp() {
        service = new TaskService();
        task = new Task("001", "Initial Task", "Initial description");
        service.addTask(task);
    }

    @Test
    public void testAddTaskSuccess() {
        Task newTask = new Task("002", "New Task", "Another task description");
        service.addTask(newTask);
        assertDoesNotThrow(() -> service.updateName("002", "Updated Name"));
    }

    @Test
    public void testAddDuplicateTaskIdThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.addTask(new Task("001", "Duplicate", "This should fail")));
    }

    @Test
    public void testDeleteTaskSuccess() {
        service.deleteTask("001");
        assertThrows(IllegalArgumentException.class, () ->
            service.updateName("001", "Should Fail"));
    }

    @Test
    public void testUpdateFields() {
        service.updateName("001", "Updated Task");
        assertEquals("Updated Task", task.getName());

        service.updateDescription("001", "Updated description");
        assertEquals("Updated description", task.getDescription());
    }
}

