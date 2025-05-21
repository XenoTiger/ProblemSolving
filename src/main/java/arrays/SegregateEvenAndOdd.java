package arrays;

public class SegregateEvenAndOdd {

    private static void segregateEvenAndOdd(int[] arr) {
        int i = -1;
        int j = 0;
        int n = arr.length;
        while (j != n) {
            if (arr[j] % 2 == 0) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
            j++;
        }

        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        segregateEvenAndOdd(arr);
    }
}
