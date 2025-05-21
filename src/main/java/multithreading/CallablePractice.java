package multithreading;

import java.util.concurrent.*;

public class CallablePractice {

    private static void sumUsingCallable(int[] arr) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> sumOfArray(arr);
        Future<Integer> future = executor.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }

    private static void sumUsingCompletableFuture(int[] arr) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sumOfArray(arr));
        System.out.println(completableFuture.join());
    }

    private static void printMessage() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello World");
        });
        System.out.println(completableFuture.join());

    }

    private static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 6}; //sum of elements of array using callable
        sumUsingCallable(arr);
        sumUsingCompletableFuture(arr);
        printMessage();
    }
}
