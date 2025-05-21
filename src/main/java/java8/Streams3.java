package java8;

import java.util.*;
import java.util.stream.Collectors;

public class Streams3 {

    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1(101, "Alice Johnson", "Engineering", "alice.johnson@gmail.com", 50, 95000),
                new Employee1(102, "Bob Smith", "Marketing", "bob.smith@yahoo.com", 30, 72000),
                new Employee1(103, "Charlie Brown", "HR", "charlie.brown@outlook.com", 20, 68000),
                new Employee1(104, "David Miller", "Engineering", "david.miller@gmail.com", 70, 105000),
                new Employee1(105, "Emma Wilson", "Finance", "emma.wilson@company.com", 40, 80000),
                new Employee1(106, "Frank Harris", "IT Support", "frank.harris@company.com", 25, 60000),
                new Employee1(107, "Grace Thompson", "Engineering", "grace.thompson@company.com", 65, 98000),
                new Employee1(108, "Hannah White", "Legal", "hannah.white@company.com", 15, 90000),
                new Employee1(109, "Isaac Adams", "Marketing", "isaac.adams@gmail.com", 35, 75000),
                new Employee1(110, "Jack Lee", "Sales", "jack.lee@yahoo.com", 45, 85000),
                new Employee1(111, "Karen Clark", "IT Support", "karen.clark@company.com", 28, 62000),
                new Employee1(112, "Leo Martin", "Engineering", "leo.martin@gmail.com", 55, 97000),
                new Employee1(113, "Mia Robinson", "Finance", "mia.robinson@company.com", 38, 81000),
                new Employee1(114, "Nathan Scott", "HR", "nathan.scott@outlook.com", 22, 69000),
                new Employee1(115, "Olivia Turner", "Sales", "olivia.turner@gmail.com", 50, 87000)
        );

        // domain count
        Map<String, Long> map = employees.stream()
                .map(e -> e.getEmail().split("@")[1])
                .collect(Collectors.groupingBy(domain -> domain, Collectors.counting()));

        map.forEach((domain, count) -> {
            System.out.println(domain + ":" + count);
        });

        System.out.println("*************************");

        // employee with the highest commit count for each department
        Map<String, Optional<Employee1>> employeeMap = employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.maxBy(Comparator.comparing(Employee1::getCommitCount))));

        employeeMap.forEach((dept, emp) -> {
            System.out.println(dept + ":" + emp.map(Employee1::getName).orElse(null));
        });

        System.out.println("*************************");

        // count employees in each department
        Map<String, Long> employeeCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));
        System.out.println(employeeCountMap);

        System.out.println("*************************");

        // highest salary in each department
        Map<String, Optional<Employee1>> salaryMap = employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary))));
        salaryMap.forEach((dept, salary) -> {
            System.out.println(dept + " : " + salary.map(Employee1::getSalary).orElse(null));
        });

        System.out.println("*************************");

        // group departments and total salary of each dept.
        Map<String, Double> totalSalaryMap = employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.summingDouble(Employee1::getSalary)));
        totalSalaryMap.forEach((dept, salary) -> {
            System.out.println(dept + " : " + salary);
        });
    }
}

 class Employee1 {
    private int id;
    private String name;
    private String department;
    private String email;
    private int commitCount;
    private double salary;

    // Constructor, getters, and setters...

    public Employee1(int id, String name, String department, String email, int commitCount, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.commitCount = commitCount;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getCommitCount() {
        return commitCount;
    }

    public double getSalary() {
        return salary;
    }
}
