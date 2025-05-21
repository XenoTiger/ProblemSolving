package arrays;

public class FibonacciSeries {

    private static void fiibonacci(int n) {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            System.out.println(next);
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        fiibonacci(10);
    }
}
