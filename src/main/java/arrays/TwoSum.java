package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    private static List<List<Integer>> findPairs(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                List<Integer> inner = new ArrayList<>();
                inner.add(map.get(complement));
                inner.add(i);
                result.add(inner);
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 7, -1, 0, 5};
        int target = 6;
        List<List<Integer>> result = findPairs(arr, target);
        System.out.println(result);
    }
}
