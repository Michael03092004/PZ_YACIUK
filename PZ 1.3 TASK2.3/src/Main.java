import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int emptyLineCount = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                emptyLineCount++;
            }
            if (line.equals("break")) {
                break;
            }
        }
        System.out.println("Кількість порожніх рядків: " + emptyLineCount);
        scanner.close();
        }
    }
