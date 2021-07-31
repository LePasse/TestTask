package task;

import java.util.ArrayList;
import java.util.List;

public class OrderProductParser {
    private final String filename;
    private final List<OrderProduct> orderProducts;

    public OrderProductParser(String filename) {
        this.filename = filename;
        this.orderProducts = new ArrayList<>();
        try {
            parseOrderProducts();
        } catch (Exception e) {
            System.out.println("Error occured during parsing order_items.csv");
        }
    }

    private void parseOrderProducts() throws Exception {
        CsvReader csvReader = new CsvReader(filename);
        List<String[]> orderProducts = csvReader.readAll();
        orderProducts.remove(0);
        for (String[] orderProduct : orderProducts) {
            this.orderProducts.add(new OrderProduct(orderProduct[0], orderProduct[1], Integer.parseInt(orderProduct[2])));
        }
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }
}
