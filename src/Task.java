public class Task {
    private String taskName;
    private int taskId;

    public Task(String taskName, int taskId) {
        this.taskName = taskName;
        this.taskId = taskId;
    }

    public void execute() {
        System.out.println("Выполняется задача: " + taskName + " (ID: " + taskId + ")");
        try {
            Thread.sleep(1000); // Имитация работы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskId() {
        return taskId;
    }
}
