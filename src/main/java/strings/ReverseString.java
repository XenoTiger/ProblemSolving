package strings;

public class ReverseString {

    private static String reverse(String s){
        String trimmed = s.trim().replaceAll("\\s+", " ");
        String[] words = trimmed.split(" ");
        int left = 0;
        int right = words.length-1;

        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println(reverse(s1));
        String s2 = " Have a  nice day! ";
        System.out.println(reverse(s2));
    }
}
