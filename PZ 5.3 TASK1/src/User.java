public class User implements Runnable {
    private final PrintServer printServer;

    public User(PrintServer printServer) {
        this.printServer = printServer;
    }

    @Override
    public void run() {
        try {
            // Створюємо випадкову кількість завдань (2 < N < 6)
            int tasksCount = (int) (Math.random() * 4) + 2;

            for (int i = 0; i < tasksCount; i++) {
                String task = "Завдання користувача " + Thread.currentThread().getId() + "-" + (i + 1);
                printServer.addTask(task);
                Thread.sleep(100); // Спимо для демонстрації
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}