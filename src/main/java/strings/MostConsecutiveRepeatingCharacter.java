package strings;

public class MostConsecutiveRepeatingCharacter {

    private static char maxRepeating(String s) {
        int n = s.length();
        int maxCount = 0;
        int count = 1;
        char res = s.charAt(0);

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                res = s.charAt(i - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaabbaaccde";
        System.out.println(maxRepeating(s));
    }
}
