package strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        String left = arr[0];
        String right = arr[arr.length - 1];

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return sb.toString();
            } else {
                sb.append(left.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geeer"};
        System.out.println(longestCommonPrefix(arr));
    }
}
