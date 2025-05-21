package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentElement {

    private static int findMostFrequentElementUsingStreams(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry<Integer, Long>::getValue) // Compare by frequency
                        .thenComparing(Map.Entry::getKey, Comparator.reverseOrder())) // In case of tie, choose smaller number
                .get()
                .getKey();
    }

    private static int findMostFrequentElement(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maxCount = 0;
        int mostFrequent = -1;
        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > maxCount || (count == maxCount && num < mostFrequent)) {
                maxCount = count;
                mostFrequent = num;
            }

        }

        return mostFrequent;

    }

    public static void main(String[] args) {

        int[] numArray = {2, 2, 3, 1, 3, 4};

        System.out.println(findMostFrequentElementUsingStreams(numArray));
        System.out.println(findMostFrequentElement(numArray));

    }
}
