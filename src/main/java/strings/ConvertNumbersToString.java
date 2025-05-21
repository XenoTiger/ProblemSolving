package strings;

public class ConvertNumbersToString {

    private static final String[] numbersToWord = {
            "Zero", "One", "Two", "Three",
            "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private static String convertNumberToString(int number) {
        StringBuilder sb = new StringBuilder();
        String numbers = String.valueOf(number);

        for (char c : numbers.toCharArray()) {
            int digit = c - '0';
            sb.append(numbersToWord[digit]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println(convertNumberToString(number));

    }
}
