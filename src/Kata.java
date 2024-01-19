import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Kata {

    static Pattern pattern = Pattern.compile("-?\\d+");
    public static void main(String[] args) throws Exception {
        System.out.println(Add("1,2,345"));
        System.out.println(Add("1\\n2,3"));
        System.out.println("//[|||]\\n1|||2|||3");
        System.out.println("//[|][%]\\n1|2%3");
        System.out.println(Add("1,-2,-3,sadsafds-45"));
    }

    public static int Add(String numbers) throws Exception{
        int sum = 0;
        ArrayList<Object> negatives = new ArrayList<>();
        Matcher matcher = pattern.matcher(numbers);
        while (matcher.find()) {
                int number = Integer.valueOf(numbers.substring(matcher.start(), matcher.end()));
                if (number < 0) {
                    negatives.add(number);
                }
                sum += number;
        }

        if (!negatives.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negatives.toString());
        }

        return sum;
    }
}