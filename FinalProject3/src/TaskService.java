import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the service. Task ID must be unique.
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Deletes a task by task ID.
     */
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId);
    }

    /**
     * Updates the name of a task.
     */
    public void updateName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    /**
     * Updates the description of a task.
     */
    public void updateDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }

    /**
     * Helper method to retrieve task or throw error if not found.
     */
    private Task getTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return tasks.get(taskId);
    }
}
