package arrays;

public class MissingNumberInArray {

    private static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            if(num > 0){
                actualSum += num;
            }
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, -1, 1 };
        System.out.println(findMissingNumber(arr));
    }
}
