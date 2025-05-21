package arrays;

public class ShiftAllOnesToLeft {

    private static void shiftAllOnesToLeft(int[] arr) {
        int low = 0;
        for (int mid = 0; mid < arr.length; mid++) {
            if (arr[mid] == 1) {
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 4, 1, 1, 2, 1, 3, 1};
        shiftAllOnesToLeft(arr);
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }
}
