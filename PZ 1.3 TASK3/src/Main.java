import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Test1("Valik22!", "Integer7!", "!!data!!");
        Test2("Valik22!", "int0#aaa", "!!data!!");
    }
    public static void Test1(String... logins) {
        String pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%]).{8,}$";
        Pattern loginPattern = Pattern.compile(pattern);

        for (String login : logins) {
            Matcher matcher = loginPattern.matcher(login);
            if (matcher.matches()) {
                System.out.println("Дійсний логін (Test1): " + login);
            } else {
                System.out.println("Недійсний логін (Test1): " + login);
            }
        }
    }

    public static void Test2(String... logins) {
        for (String login : logins) {
            if (isValidLogin(login)) {
                System.out.println("Дійсний логін (Test2): " + login);
            } else {
                System.out.println("Недійсний логін (Test2): " + login);
            }
        }
    }

    public static boolean isValidLogin(String login) {
        if (login.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < login.length(); i++) {
            char ch = login.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if ("!#$%".indexOf(ch) != -1) {
                hasSpecialChar = true;
            }
        }
        return hasDigit && hasLowercase && hasUppercase && hasSpecialChar;
    }
}