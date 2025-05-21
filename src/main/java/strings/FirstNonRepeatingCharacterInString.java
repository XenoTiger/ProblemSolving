package strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacterInString {

    private static String getFirstNonRepeatingCharacter(String s){
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

    }

    private static String getFirstRepeatingCharacter(String s){
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        String s = "Java Programming";
        System.out.println(getFirstNonRepeatingCharacter(s));
        System.out.println(getFirstRepeatingCharacter(s));
    }
}
