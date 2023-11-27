import java.util.LinkedList;
import java.util.Queue;

public class PrintServer {
    private final Queue<String> printQueue = new LinkedList<>();
    private static final int MAX_TASKS = 10;

    public synchronized void addTask(String task) throws InterruptedException {
        while (printQueue.size() >= MAX_TASKS) {
            // Чекаємо, коли кількість завдань в черзі стане менше максимальної
            wait();
        }

        printQueue.offer(task);
        System.out.println("Завдання додано до черги: " + task);

        // Сповіщаємо всі потоки, які чекають на чергу
        notifyAll();
    }

    public synchronized void printTask() throws InterruptedException {
        while (printQueue.isEmpty()) {
            // Чекаємо, коли в черзі з'явиться завдання
            wait();
        }

        String task = printQueue.poll();
        System.out.println("Завдання виконано: " + task);

        // Сповіщаємо всі потоки, які чекають на чергу
        notifyAll();
    }
}