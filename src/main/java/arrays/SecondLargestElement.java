package arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 3};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third  = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            } else if (num > third && num != second) {
                third = num;
            }
        }

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
