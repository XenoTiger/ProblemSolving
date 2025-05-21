package arrays;

public class RearrangeArray {

    /*
    Rearrange array like large no first and then small no...
     */
    private static void reArrangeArray(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        boolean flag = true;
        int small = 0;
        int large = n - 1;

        for (int i = 0; i < n; i++) {
            if (flag) {
                temp[i] = arr[large--];
            } else {
                temp[i] = arr[small++];
            }
            flag = !flag;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reArrangeArray(arr);
        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}
