package by.sergel.entities;

public class Product {
    private String id;
    private String name;
    private long price;

    public Product(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = Long.parseLong(price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
