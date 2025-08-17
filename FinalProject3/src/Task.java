public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Setters first

    /**
     * Sets the task name (max 20 characters, not null).
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    /**
     * Sets the task description (max 50 characters, not null).
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    // Constructor

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        this.taskId = taskId;
        setName(name);
        setDescription(description);
    }

    // Getters

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
