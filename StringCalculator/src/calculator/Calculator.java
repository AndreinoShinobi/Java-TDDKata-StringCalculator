package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String acceptedDelimitersRegex = ",|\n";
    public static final String changeDelimiterPatternString = "//.*.\n.*";


    public static int add(String text) {
        if (text.isEmpty()) return 0;
        String[] tokens = tokenize(text);
        return sumStringTokensValues(tokens);
    }

    private static String[] tokenize(String text) {

        if (useDifferentDelimiter(text))
            return text.substring(4).split(retrieveDelimiter(text));

        return text.split(acceptedDelimitersRegex);
    }

    private static boolean useDifferentDelimiter(String text) {
        Pattern pattern = Pattern.compile(changeDelimiterPatternString);
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }

    private static String retrieveDelimiter(String text) {
        return text.split("//|\n")[1];
    }

    private static int sumStringTokensValues(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
