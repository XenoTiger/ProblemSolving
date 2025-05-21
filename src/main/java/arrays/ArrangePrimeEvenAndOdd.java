package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrangePrimeEvenAndOdd {

    private static List<Integer> rearrangePrimeEvenAndOdd(int[] arr) {
        List<Integer> result = new ArrayList<>();

        List<Integer> prime = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : arr) {
            if (isPrime(num)) {
                prime.add(num);
            } else if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        Collections.sort(prime);
        Collections.sort(even);
        Collections.sort(odd);

        result.addAll(prime);
        result.addAll(even);
        result.addAll(odd);

        return result;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 2, 9, 11, 10, 1, 13, 8};
        System.out.println(rearrangePrimeEvenAndOdd(arr));

    }
}
