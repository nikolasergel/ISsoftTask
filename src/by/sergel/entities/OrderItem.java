package by.sergel.entities;

public class OrderItem {
    private String orderId;
    private String productId;
    private long quantity;

    public OrderItem(String orderId, String productId, String quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = Long.parseLong(quantity);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public long getQuantity() {
        return quantity;
    }
}
