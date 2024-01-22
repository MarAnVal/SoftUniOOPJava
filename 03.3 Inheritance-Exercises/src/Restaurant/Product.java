package Restaurant;

import java.math.BigDecimal;

public class Product {
    //· name – String
    private String name;
    //· price - BigDecimal
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    //· Getters for the fields

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
