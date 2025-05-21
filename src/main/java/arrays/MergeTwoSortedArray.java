package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MergeTwoSortedArray {

    private static int[] mergeSortedArraysUsingStream(int[] arr1, int[] arr2){
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
              //  .sorted()
                .distinct()
                .toArray();
    }

    private static int[] mergeSortedArraysUsingMinHeap(int[] arr1, int[] arr2){
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num: arr1){
            minheap.add(num);
        }
        for(int num : arr2){
            minheap.add(num);
        }

        int[] mergedArray = new int[arr1.length + arr2.length];
        int i=0;
        while(!minheap.isEmpty()){
            mergedArray[i++] = minheap.poll();
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = { 4,5,6,7};
        System.out.println(Arrays.toString(mergeSortedArraysUsingStream(arr1, arr2)));
        System.out.println(Arrays.toString(mergeSortedArraysUsingMinHeap(arr1, arr2)));
    }
}
