package task;

import java.util.Date;

public class Order {
    private final String orderId;
    private final String date;

    public Order(String orderId, String date) {
        this.orderId = orderId;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }
}
