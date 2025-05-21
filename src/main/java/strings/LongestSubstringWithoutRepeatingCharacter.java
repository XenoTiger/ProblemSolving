package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    private static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int n = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int end = 0; end < n; end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLength = Math.max(maxLength, (end - start + 1));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
