import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String binary = "Двійковій";
        String dexecmicinal = "Шіснадцятиковий";
        Ex12(16,dexecmicinal );
        Ex12(2,binary);
    }
    static  void Ex12(int x ,String text){
        System.out.println("Введіть "+ text + " код для перетворення в ціле число ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt (x)){
            System.out.println(text +" перетворене на ціле число, має значення"+"\n" + scanner.nextInt(x)+"\n");
        }

        else {
            System.out.println("введене значення не є шістнадцятковим i  не двійковим");
        }
    }
}
