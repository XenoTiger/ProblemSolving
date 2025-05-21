package arrays;

import java.util.*;

public class FindCommonMinIndexSum {

    private static List<String> findCommonMinIndexSum(List<String> list1, List<String> list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.size(); j++) {
            String str = list2.get(j);
            if (map.containsKey(str)) {
                int sum = map.get(str) + j;
                if (sum < minSum) {
                    result.clear();
                    result.add(str);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(str);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("java", "python", "go", "ruby");
        List<String> list2 = Arrays.asList("scala", "java", "go", "python");
        System.out.println(findCommonMinIndexSum(list1, list2));

        System.out.println("*********");

        List<String> list3 = Arrays.asList("String2", "String1");
        List<String> list4 = Arrays.asList("String1", "String2");
        System.out.println(findCommonMinIndexSum(list3, list4));

    }
}
