package arrays;

public class TrappingRainWater {

    private static int trap(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int lmax = 0;
        int rmax = 0;
        int ans = 0;

        while (left < right) {
            lmax = Math.max(lmax, arr[left]);
            rmax = Math.max(rmax, arr[right]);

            if (lmax < rmax) {
                ans += lmax - arr[left];
                left++;
            } else {
                ans += rmax - arr[right];
                right--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr1));
        int[] arr2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr2));
    }
}
