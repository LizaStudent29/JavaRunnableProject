public class TaskService {

    public void processTask(Task task) {
        System.out.println("Сервис обрабатывает: " + task.getTaskName());
        task.execute();
    }

    public void showActiveThreads() {
        System.out.println("\n=== АКТИВНЫЕ ПОТОКИ ===");
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parentGroup;
        while ((parentGroup = rootGroup.getParent()) != null) {
            rootGroup = parentGroup;
        }

        Thread[] threads = new Thread[rootGroup.activeCount()];
        int count = rootGroup.enumerate(threads, true);

        for (int i = 0; i < count; i++) {
            Thread thread = threads[i];
            System.out.println("Поток: " + thread.getName() +
                    " | ID: " + thread.getId() +
                    " | Статус: " + thread.getState());
        }
    }
}
