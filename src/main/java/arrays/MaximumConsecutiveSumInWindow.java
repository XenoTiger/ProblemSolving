package arrays;

public class MaximumConsecutiveSumInWindow {

    private static int maximumSumOfConsecutiveWindowSize(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException("Array size must be at least k");
        }

        int currSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }
        maxSum = currSum;

        for (int i = k; i < arr.length; i++) {
            currSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 8};
        int k = 3;
        System.out.println(maximumSumOfConsecutiveWindowSize(arr, k));

    }
}
