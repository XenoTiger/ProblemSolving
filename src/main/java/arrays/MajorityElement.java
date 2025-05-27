package arrays;

public class MajorityElement {
    /*
    find the majority element—the element that appears more than n/2 times in the array.
     */
    private static int getMajorityElement(int[] arr) {
        int count = 0;
        int candidate = -1;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(getMajorityElement(arr));
    }
}
