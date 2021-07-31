package task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderParser {
    private final String filename;
    private final List<Order> orders;

    public OrderParser(String filename) {
        this.filename = filename;
        this.orders = new ArrayList<>();
        try {
            parseOrders();
        } catch (Exception e) {
            System.out.println("Error occured during parsing orders.csv");
        }
    }

    private void parseOrders() throws Exception {
        CsvReader csvReader = new CsvReader(filename);
        List<String[]> orders = csvReader.readAll();
        orders.remove(0);
        for (String[] order : orders) {
            this.orders.add(new Order(order[0], order[1].substring(0,10)));
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
