package arrays;

public class RemoveDuplicatesFromSortedArray {

    private static void removeDuplicates(int[] arr) {
        if (arr.length == 0) return;
        int j = 0;
        System.out.print(arr[0] + "\t");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
                System.out.print(arr[j] + "\t");
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6};
        removeDuplicates(arr);
    }
}
