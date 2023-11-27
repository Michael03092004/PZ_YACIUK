import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String json = null;
        try {
            json = new Scanner(new URL("https://api.weatherapi.com/v1/forecast.json?key=0594c70e007c4c5fb1470803230709&q=Kiev&days=1&aqi=no&alerts=no").openStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String pattern = "time\":\"(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})\".*?\"temp_c\":(.*?),.*?\"text\":\"(.*?)\".*?\"chance_of_rain\":(.*?),.*?";
        Pattern rx = Pattern.compile(pattern);
        Matcher matcher = rx.matcher(json);
        int count = 0;
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        while (matcher.find()) {
            String[] part = matcher.group(1).split("[-\\s:]+");
            int num = Integer.parseInt(part[3]);
            if (num >= hour && count % 2 == 1)
                System.out.printf("%s, %s°C, %s, chance_of_rain %s\n", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
            count+=1;
        }
        }
    }
