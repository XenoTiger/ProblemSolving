package strings;

public class TransformString {

    private static String transformString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        sb.append(s.charAt(s.length() - 1)).append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabccdaa";
        System.out.println(transformString(str));
    }
}
