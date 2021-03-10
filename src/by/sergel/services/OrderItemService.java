package by.sergel.services;

import by.sergel.entities.Order;
import by.sergel.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemsByOrder(Order order);

    List<OrderItem> getAllOrderItemsByListOrders(List<Order> orders);
}
