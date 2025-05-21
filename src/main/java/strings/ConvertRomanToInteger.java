package strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInteger {

    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));

            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV"; // 1994
        System.out.println("Integer value of " + roman + " is: " + romanToInt(roman));
    }
}
