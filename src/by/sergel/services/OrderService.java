package by.sergel.services;

import by.sergel.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrdersForMonth(String date);
}
