public class Main {

    public static void main(String[] args) {
        TaskService service = new TaskService();

        // Создание задач
        Task task1 = new Task("Подсчет чисел", 1);
        Task task2 = new Task("Логирование данных", 2);
        Task task3 = new Task("Обработка запроса", 3);

        System.out.println("=== ЗАПУСК ПОТОКОВ ===\n");

        // Создание потоков через наследование Thread
        CounterWorker thread1 = new CounterWorker(service, task1, 1, "CounterWorker-1");
        CounterWorker thread2 = new CounterWorker(service, task2, 2, "CounterWorker-2");

        // Создание потоков через реализацию Runnable
        Thread thread3 = new Thread(new LoggerThread(service, task3, 1, "LoggerThread-1"), "LoggerThread-1");
        Thread thread4 = new Thread(new LoggerThread(service, task1, 2, "LoggerThread-2"), "LoggerThread-2");

        // Запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Ожидание завершения всех потоков
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вывод активных потоков
        service.showActiveThreads();

        System.out.println("\n=== ВСЕ ПОТОКИ ЗАВЕРШЕНЫ ===");
    }
}