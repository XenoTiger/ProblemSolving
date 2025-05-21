package arrays;

public class TwoMissingNumbers {

    private static void printTwoMissingNumber(int[] arr, int n) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n - 2; i++) {
            visited[arr[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.print(i + "\t");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int n = 2 + arr.length;
        printTwoMissingNumber(arr, n);
    }
}
