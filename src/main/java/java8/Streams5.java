package java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Streams5 {

    public static void main(String[] args) {

        Product p1 = new Product("Laptop", "Baby", 1200);
        Product p2 = new Product("Smartphone", "Electronics", 800);
        Product p3 = new Product("TV", "Electronics", 1500);
        Product p4 = new Product("Sofa", "Baby", 700);
        Product p5 = new Product("Table", "Furniture", 300);
        Product p6 = new Product("Bed", "Baby", 900);

        // Creating Orders
        Order order1 = new Order(101, LocalDate.of(2024, 2, 20), Arrays.asList(p1, p2));
        Order order2 = new Order(102, LocalDate.of(2024, 2, 20), Arrays.asList(p4, p6));
        Order order3 = new Order(103, LocalDate.of(2024, 2, 21), Arrays.asList(p3, p5));
        Order order4 = new Order(104, LocalDate.of(2024, 2, 22), Arrays.asList(p2, p6));


        // List of Orders
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        //Give the list of orders which have any product with category "Baby"
        List<Order> list = orders.stream().filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .toList();
        list.forEach(System.out::println);

        //List of products
        List<Product> products = orders.stream().flatMap(order -> order.getProducts().stream()).toList();

        //get the most expensive product name for each category
        Map<String, Optional<Product>> categoryMap = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        categoryMap.forEach((category, product) -> {
            System.out.println(category + " : " + product.map(Product::getName).orElse("N/A"));
        });

        //Find the average price of all order place on one specific date.
        LocalDate date =  LocalDate.of(2024, 2, 20);
        OptionalDouble averagePrice = orders.stream().filter(order -> order.getOrderDate().equals(date))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice).average();

        System.out.println(averagePrice.orElse(0));

    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private int orderId;
    private LocalDate orderDate;
    private List<Product> products;

    public Order(int orderId, LocalDate orderDate, List<Product> products) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", products=" + products +
                '}';

    }
}
