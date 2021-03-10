package by.sergel.services;

import by.sergel.entities.Order;
import by.sergel.entities.OrderItem;
import by.sergel.repositories.ProductRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private OrderService orderService;
    private OrderItemService orderItemService;

    public ProductServiceImpl(OrderService orderService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @Override
    public String getNameOfMaxForMonth(String strDate) {
        List<Order> orders = orderService.getAllOrdersForMonth(strDate);
        List<OrderItem> allOrderItemsByListOrders = orderItemService.getAllOrderItemsByListOrders(orders);
        Set<OrderItem> checked = new HashSet<>();

        long maxPrice = 0;
        long buff;
        String nameOfMax = "";
        for (OrderItem orderItem : List.copyOf(allOrderItemsByListOrders)) {
            if (!checked.contains(orderItem)) {
                checked.add(orderItem);
                buff = allOrderItemsByListOrders
                        .stream()
                        .filter(oi -> oi.getProductId().equals(orderItem.getProductId()))
                        .mapToLong(OrderItem::getQuantity)
                        .sum();
                buff *= ProductRepository.getProductById(orderItem.getProductId()).getPrice();
                if (buff > maxPrice) {
                    maxPrice = buff;
                    nameOfMax = ProductRepository.getProductById(orderItem.getProductId()).getName();
                }
            }
        }
        return nameOfMax;
    }
}
