package by.sergel.repositories;

import by.sergel.entities.OrderItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemRepository {
    private static List<OrderItem> orderItems;

    static {
        orderItems = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("order_items.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                orderItems.add(new OrderItem(values[0], values[1], values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<OrderItem> findAllByOrderId(String orderId) {
        return orderItems.stream()
                .filter(o -> orderId.equals(o.getOrderId()))
                .collect(Collectors.toList());
    }
}
