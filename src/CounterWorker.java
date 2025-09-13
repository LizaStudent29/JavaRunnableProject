public class CounterWorker extends Thread {
    private final TaskService service;
    private final Task task;
    private final int threadNumber;

    public CounterWorker(TaskService service, Task task, int threadNumber, String name) {
        super(name);
        this.service = service;
        this.task = task;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Поток " + getName() + " (номер: " + threadNumber + ") запущен");
        service.processTask(task);
        System.out.println("Поток " + getName() + " завершил работу");
    }
}
