package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {

        //sum of elements
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 1);
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        //remove duplicates
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        listOfStrings.stream().distinct().toList().forEach(System.out::print);

        //remove duplicates and sort
        listOfStrings.stream().distinct().sorted().forEach(System.out::println);

        //frequency of each character in a string
        String inputString = "JavaConceptOfTheDay";
        String[] array = inputString.split("");
        Map<String, Long> map = Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        //frequency of each element in an array or a list
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> map1 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map1);

        //sort the given list of decimals in reverse order
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter
        List<String> listOfString = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joinedString = listOfString.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedString);

        //find maximum and minimum
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int max = listOfIntegers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        int min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max: " + max + " Min: " + min);

        //merge two unsorted arrays into single sorted array and without duplicates
        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 1, 9, 2};
        int[] result = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(result));

        //get three maximum numbers and three minimum numbers from the given list of integers
        List<Integer> integers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        integers.stream().sorted().limit(3).forEach(System.out::println);
        integers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

        //two strings are anagrams or not
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 = Stream.of(s1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }

        //sum of all digits of a number
        int i = 15623;
        int sumOfDigits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sumOfDigits);

        //second-largest number in an integer array
        List<Integer> integerList = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int number = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(number);

        // sort them according to increasing order of their length
        List<String> strings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        strings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        //find sum and average of all elements
        int[] arr = new int[]{45, 12, 56, 15, 24, 75, 31, 89};
        int sum = Arrays.stream(arr).sum();
        double avg = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Sum: " + sum + " Avg: " + avg);

        // find common elements between two arrays
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);

        //reverse each word of a string
        String str = "Java Concept Of The Day";
        String reverseString = Arrays.stream(str.split(" ")).map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(""));
        System.out.println(reverseString);

        //find sum of first 10 natural numbers
        System.out.println(IntStream.range(1,11).sum());

        //first 10 even numbers
        IntStream.rangeClosed(1, 10).map(n -> n * 2).forEach(System.out::println);

        //extract duplicate elements from an array
        List<Integer> intList = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> set = intList.stream().filter(e -> !uniqueElements.add(e)).collect(Collectors.toSet());
        System.out.println(set);

        //print duplicate characters in a string
        String s = "Java Concept Of The Day".replaceAll("\\s+","").toLowerCase();
        Set<String> uniqueChars = new HashSet<>();
        Set<String> duplicate = Arrays.stream(s.split("")).filter(d -> !uniqueChars.add(d))
                .collect(Collectors.toSet());
        System.out.println(duplicate);

        //sum using reduce()
        int sumOfInt = list1.stream().reduce(0, Integer::sum);
        System.out.println(sumOfInt);


    }
}
