package arrays;

public class ProductOfArrayExceptSelf {

    private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int prefix = 1;
        int postfix = 1;

        for (int i = 0; i < n; i++) {
            ans[i] = prefix;
            prefix = prefix * arr[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = postfix * ans[i];
            postfix = postfix * arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ans = productExceptSelf(arr);
        for (int n : ans) {
            System.out.print(n + "\t");
        }
    }
}
