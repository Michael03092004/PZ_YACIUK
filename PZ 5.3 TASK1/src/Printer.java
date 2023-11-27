public class Printer implements Runnable {
    private final PrintServer printServer;
    public Printer(PrintServer printServer) {
        this.printServer = printServer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                printServer.printTask();
                Thread.sleep(200); // Спимо для демонстрації
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}