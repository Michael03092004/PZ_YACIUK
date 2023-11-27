
public class Main {
    public static void main(String[] args) {
        String[] code = { "AUD", "GBP", "BYR" };
        int[] unit = { 1, 1,1000};
        String[] currency = {"Австралійський долар", "Фунт стерлінгів", "Білоруський рубль" };
        double[] equivalent = { 23.9883, 45.8429, 19.7716 };

        System.out.println("Код  | Одиниці | Валюта             | Еквівалент");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < code.length; i++) {
            System.out.printf("%4s | %-8d | %-20s | %.1f%n", code[i], unit[i], currency[i], equivalent[i]);
        }

        }
    }
