package by.sergel.services;

import by.sergel.entities.Order;
import by.sergel.entities.OrderItem;
import by.sergel.repositories.OrderItemRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public List<OrderItem> getOrderItemsByOrder(Order order) {
        return OrderItemRepository.findAllByOrderId(order.getId());
    }

    @Override
    public List<OrderItem> getAllOrderItemsByListOrders(List<Order> orders) {
        return orders
                .stream()
                .map(order -> OrderItemRepository.findAllByOrderId(order.getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
