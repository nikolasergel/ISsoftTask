package by.sergel;

import by.sergel.services.*;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl(new OrderServiceImpl(), new OrderItemServiceImpl());
        System.out.println("Product name: " + productService.getNameOfMaxForMonth("2021-01-21"));
    }
}
