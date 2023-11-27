
public class Main {
    public static void main(String[] args) {
        PrintServer printServer = new PrintServer();

        // Створюємо потоки користувачів і принтерів
        for (int i = 0; i < 3; i++) {
            new Thread(new User(printServer)).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Printer(printServer)).start();
        }

        }
    }
