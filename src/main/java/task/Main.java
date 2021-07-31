package task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        OrderParser orderParser = new OrderParser("orders.csv");
        ProductParser productParser = new ProductParser("products.csv");
        OrderProductParser orderProductParser = new OrderProductParser("order_items.csv");

        System.out.println(getLeader("2021-01-21", orderParser, productParser, orderProductParser));
    }

    private static String getLeader(String date, OrderParser orderParser, ProductParser productParser, OrderProductParser orderProductParser) {
        List<Order> orders = orderParser.getOrders();
        List<Product> products = productParser.getProducts();
        List<OrderProduct> orderProducts = orderProductParser.getOrderProducts();

        orders = orders.stream().filter(o -> date.equals(o.getDate())).collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();
        for (Order order : orders) {
            orderProducts.stream().filter(op -> order.getOrderId().equals(op.getOrderId())).forEach(op -> {
                if (map.containsKey(op.getProductId())) {
                    //map.put(op.getProductId(), map.get(op.getProductId()) + op.getQuantity());
                    map.replace(op.getProductId(), map.get(op.getProductId()) + op.getQuantity());
                } else {
                    map.put(op.getProductId(), op.getQuantity());
                }
            });
        }

        int max = 0;
        String id = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int price = entry.getValue() * products.stream().filter(p -> entry.getKey().equals(p.getProductId())).collect(Collectors.toList()).get(0).getPrice();
            if (price > max) {
                max = price;
                id = entry.getKey();
            }
        }
        String finalId = id;
        
        return products.stream().filter(p -> finalId.equals(p.getProductId())).collect(Collectors.toList()).get(0).getName();
    }
}

