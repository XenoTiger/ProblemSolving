package java8;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams2 {

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(1, new BigDecimal("100.25"), "EUR", "COMPLETED"),
                new Transaction(2, new BigDecimal("200.50"), "EUR", "COMPLETED"),
                new Transaction(3, new BigDecimal("50.00"), "INR", "PENDING"),
                new Transaction(4, new BigDecimal("200.50"), "INR", "COMPLETED")
        );

        Map<String, BigDecimal> result = transactions.stream()
                .filter(t -> "COMPLETED".equals(t.getStatus()))
                .collect(Collectors.toMap(
                        Transaction::getCurrency,
                        Transaction::getAmount,
                        BigDecimal::add
                ));

        result.forEach((currency, totalAmount) ->
                System.out.println(currency + " : " + totalAmount));
    }
}

class Transaction {
    private int id;
    private BigDecimal amount;
    private String currency;
    private String status;

    // Constructor
    public Transaction(int id, BigDecimal amount, String currency, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    // Optional: Override toString for better output formatting
    @Override
    public String toString() {
        return "Transaction{id=" + id + ", amount=" + amount + ", currency='" + currency + "', status='" + status + "'}";
    }
}
