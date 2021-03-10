package by.sergel.repositories;

import by.sergel.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                products.add(new Product(values[0], values[1], values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product getProductById(String productId) {
        return products.stream()
                .filter(p -> productId.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }
}
