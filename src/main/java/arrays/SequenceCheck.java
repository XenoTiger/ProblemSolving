package arrays;

public class SequenceCheck {

    /*
    To check arr2 is sequence of arr2 or not.
     */
    private static boolean sequenceChecker(int[] arr1, int[] arr2) {
        if (arr2.length == 0) {
            return false;
        }

        if (arr1.length == 0) {
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                j++;
            }
            i++;
        }
        return j == arr2.length;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4};
        System.out.println(sequenceChecker(arr1, arr2));
    }
}
