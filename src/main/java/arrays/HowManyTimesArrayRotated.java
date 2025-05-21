package arrays;

public class HowManyTimesArrayRotated {

    private static int noOfTimesArrayRotated(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] arr = {12, 13, 14, 15, 1, 2, 3, 4};
        System.out.println(noOfTimesArrayRotated(arr));
    }
}
