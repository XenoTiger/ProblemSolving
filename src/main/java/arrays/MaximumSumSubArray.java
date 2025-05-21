package arrays;

public class MaximumSumSubArray {

    private static int maxSumSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int num : arr){
            currSum = currSum + num;
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {34, -50, 42, 14, -5, 86};
        System.out.println(maxSumSubArray(nums));
    }
}
