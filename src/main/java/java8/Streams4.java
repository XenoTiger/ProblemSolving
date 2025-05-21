package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams4 {

    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("apple", 5, new BigDecimal(5)),
                new Item("apple", 20, new BigDecimal(20)),
                new Item("apple", 1, new BigDecimal(1)),
                new Item("banana", 10, new BigDecimal(10)),
                new Item("banana", 20, new BigDecimal(20)),
                new Item("orange", 60, new BigDecimal(60)),
                new Item("orange", 20, new BigDecimal(20))
        );

        Map<String, List<Item>> groupedItems = items.stream()
                .collect(Collectors.groupingBy(Item::getName));

        for(Map.Entry<String, List<Item>> entry : groupedItems.entrySet()){
            String name = entry.getKey();
            List<Item> itemList = entry.getValue();

            int totalQuantity = itemList.stream().mapToInt(Item::getQuantity).sum();

            BigDecimal totalPrice = itemList.stream().map(
                    item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println(name + " " + totalQuantity + " " + totalPrice);
        }

    }
}
class Item {
    String name;
    int quantity;
    BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
