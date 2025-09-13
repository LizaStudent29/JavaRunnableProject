public class LoggerThread implements Runnable {
    private final TaskService service;
    private final Task task;
    private final int threadNumber;
    private final String threadName;

    public LoggerThread(TaskService service, Task task, int threadNumber, String name) {
        this.service = service;
        this.task = task;
        this.threadNumber = threadNumber;
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadName + " (номер: " + threadNumber + ") запущен");
        service.processTask(task);
        System.out.println("Поток " + threadName + " завершил работу");
    }
}
