import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inpyt = "some 22 of them 36 are 5 numbers -8 sdfvs 23";
        Scanner scanner = new Scanner(inpyt);
        int count = 0;

        while(scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println("Було знайдено  " + num);
                ++count;
            } else {
                scanner.next();
            }
        }
        System.out.println("Усього було знайдено " + count + " числа");
        scanner.close();
        }
    }
