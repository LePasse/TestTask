package task;

public class OrderProduct {
    private final String orderId;
    private final String productId;
    private final int quantity;

    public OrderProduct(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
