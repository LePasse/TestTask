package task;

import java.util.ArrayList;
import java.util.List;

public class ProductParser {
    private final String filename;
    private final List<Product> products;

    public ProductParser(String filename) {
        this.filename = filename;
        this.products = new ArrayList<>();
        try {
            parseProducts();
        } catch (Exception e) {
            System.out.println("Error occured during parsing products.csv");
        }
    }

    private void parseProducts() throws Exception {
        CsvReader csvReader = new CsvReader(filename);
        List<String[]> products = csvReader.readAll();
        products.remove(0);
        for (String[] product : products) {
            this.products.add(new Product(product[0], product[1], Integer.parseInt(product[2])));
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
