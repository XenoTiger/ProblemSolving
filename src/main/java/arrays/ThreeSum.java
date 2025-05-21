package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static List<List<Integer>> threeSumNonEfficient(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        ans.add(list);
                    }
                }
            }
        }           //0(n3)
        return ans;
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> result = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(result);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                }
            }
        }              //0(n2)
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumNonEfficient(nums));
        System.out.println(threeSum(nums));
    }
}
