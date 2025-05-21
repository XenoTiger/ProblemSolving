package arrays;

import java.util.*;

public class SortNumbersBasedOnCardinality {

    public static List<Integer> sortByFrequency(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        List<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            sortedList.add(num);
        }

        sortedList.sort(Comparator
                .comparing((Integer num) -> map.get(num))
                .reversed()
                .thenComparing(num -> num));

        return sortedList;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 5, 4, 3, 5, 6, 6, 4, 4};
        System.out.println(sortByFrequency(nums));
    }
}
