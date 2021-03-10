package by.sergel.repositories;

import by.sergel.entities.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private static List<Order> orders;

    static {
        orders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("orders.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                orders.add(new Order(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Order getOrderByDate(String date) {
        return orders.stream()
                .filter(o -> date.equals(o.getDate().toString()))
                .findFirst()
                .orElse(null);
    }

    public static List<Order> getAllOrdersByDate(String date) {
        return orders.stream()
                .filter(o -> date.equals(o.getDate().toString()))
                .collect(Collectors.toList());
    }

    public static List<Order> getAllOrders() {
        return orders;
    }
}
