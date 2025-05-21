package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingPractice {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 22, 50000));
        employees.add(new Employee("Jane", 14, 60000));
        employees.add(new Employee("Jack", 18, 40000));
        employees.add(new Employee("John", 27, 45000));

        employees.stream().sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        employees.stream().filter(e -> e.getAge() > 18).map(Employee::getName)
                .forEach(System.out::println);

        Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge).reversed();

        employees.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(ageComparator)).forEach(System.out::println);


        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
        map.forEach((key, val) ->
                System.out.println(key + " : " + val));

    }
}
