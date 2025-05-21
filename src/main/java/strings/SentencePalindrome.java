package strings;

public class SentencePalindrome {

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "Abc 012..##  10cbA";
        String s2 = "ABC $. def01ASDF..";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));

    }
}
