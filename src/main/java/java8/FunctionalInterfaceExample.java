package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface A {
    int sum(int a, int b);
}

public class FunctionalInterfaceExample {


    public static void main(String[] args) {

        A calculate = (int a, int b) -> a + b;
        System.out.println(calculate.sum(1,2));

        Supplier<Double> suppiler = Math::random;
        System.out.println(suppiler.get());

        Consumer<String> consumer = name -> System.out.println(name);
        consumer.accept("Hello");

        Function<String, Integer> function = strr -> strr.length();
        System.out.println(function.apply("Niraj"));

        Predicate<Integer> predicate = n -> n % 2 == 0;
        System.out.println(predicate.test(2));

    }
}
