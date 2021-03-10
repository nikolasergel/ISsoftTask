package by.sergel.services;

import by.sergel.entities.Order;
import by.sergel.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getAllOrdersForMonth(String strDate) {
        LocalDate date = LocalDate.parse(strDate);
        return OrderRepository.getAllOrders()
                .stream()
                .filter(o -> o.getDate().getYear() == date.getYear() &&
                        o.getDate().getMonthValue() == date.getMonthValue())
                .collect(Collectors.toList());
    }
}
