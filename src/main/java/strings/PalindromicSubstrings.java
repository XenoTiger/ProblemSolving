package strings;

public class PalindromicSubstrings {

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static void palindromicSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substrings = s.substring(i, j);
                if (isPalindrome(substrings)) {
                    System.out.println(substrings);
                }
            }
        }
    }

    private static void palindromicSubstringOptimized(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i); //odd length
            expandAroundCenter(s, i, i + 1); // even length;
        }
    }

    private static void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println(s.substring(left, right + 1));
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        // palindromicSubstring("aaa");
        palindromicSubstringOptimized("ababa");

    }
}
