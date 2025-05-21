package arrays;

import java.util.Arrays;

public class FirstAndLastIndexOfElement {

    private static int firstOccurrence(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int lastOccurrence(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int n = arr.length;
        int[] result = new int[2];
        int first = firstOccurrence(arr, n, target);
        int last = lastOccurrence(arr, n, target);
        result[0] = first;
        result[1] = last;
        System.out.println(Arrays.toString(result));
    }
}
