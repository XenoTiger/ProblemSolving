package arrays;

public class ContainerWithMostWater {

    private static int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int area = height * width;
            maxArea = Math.max(area, maxArea);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr1));
        int[] arr2 = {1, 1};
        System.out.println(maxArea(arr2));
    }
}
