package arrays;

public class EquilibriumIndexOfArray {

    private static int getEquilibriumIndex(int[] arr){
        int actualSum = 0;
        for(int num : arr){
            actualSum += num;
        }

        int leftSum = 0;
        for(int i=0; i< arr.length; i++){
            int rightSum = actualSum - leftSum - arr[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(getEquilibriumIndex(arr));
    }
}
