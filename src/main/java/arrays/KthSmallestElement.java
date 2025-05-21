package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    private static int KthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            System.out.println("added: " + maxHeap);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 7, 9};
        int k = 3;
        System.out.println(KthSmallestElement(arr, k));
    }
}
