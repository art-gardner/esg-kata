import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Kata {

    static Pattern pattern = Pattern.compile("-?\\d+");
    static Pattern findDelimiter = Pattern.compile(""(?<=This is)(.*)(?=sentence));
    public static void main(String[] args) throws Exception {
        //1
        //System.out.println(Add(""));
        //System.out.println(Add("1"));
        //System.out.println(Add("1,2"));
        //2	
	//System.out.println(Add("1,2,345"));
	//System.out.println(Add("5,3,7,4,6,5453,342"));
	//System.out.println(Add("7,6,3,4"));
	//3
        //System.out.println(Add("1\\n2,3"));
	//4
        System.out.println(Add("//;\n1;2"));
        //System.out.println(Add("//[|][%]\\n1|2%3"));
        //System.out.println(Add("1,-2,-3,sadsafds-45"));
    }

    public static int Add(String numbers) throws Exception{
	    String split = numbers.split("\n");
	    String delimiters = split[0].substring(1);
	    String rawNumbers = split[1];

	    delimiter 


        int sum = 0;
        ArrayList<Object> negatives = new ArrayList<>();
        Matcher matcher = pattern.matcher(numbers);
        while (matcher.find()) {
                int number = Integer.parseInt(numbers.substring(matcher.start(), matcher.end()));
                if (number < 0) {
                    negatives.add(number);
                }
                sum += number;
        }

        if (!negatives.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}
