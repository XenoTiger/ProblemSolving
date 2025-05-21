package arrays;

public class SortZeroesOnesAndTwos {

    private static void sortZeroesOnesAndTwos(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];  //2,0,2,1,1,0
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortZeroesOnesAndTwos(arr);
    }
}
