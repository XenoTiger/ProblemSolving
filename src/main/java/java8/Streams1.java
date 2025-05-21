package java8;

import java.util.*;
import java.util.stream.Collectors;

public class Streams1 {

    public static void main(String[] args) {

        Map<String, List<Integer>> studentMarks = new HashMap<>();
        studentMarks.put("Alice", Arrays.asList(85, 92, 88));
        studentMarks.put("Bob", Arrays.asList(78, 81, 74));
        studentMarks.put("Charlie", Arrays.asList(90, 91, 89));

        Map<String, Integer> marks = studentMarks.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max(Comparator.naturalOrder())
                                .orElse(0)));

        marks.forEach((student, mark) -> System.out.println(student + " : " + mark));

        System.out.println("********************************");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = list.stream().filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n).sum();
        System.out.println(sum);

    }
}
