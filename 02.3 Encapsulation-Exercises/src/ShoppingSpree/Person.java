package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setMoney(money);
        this.setName(name);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validations.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validations.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalStateException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        this.money -= product.getCost();
        this.products.add(product);
    }

    public String getName() {
        return name;
    }

    public String viewBought() {
        StringBuilder statistic = new StringBuilder();
        statistic.append(this.name + " - ");
        if (this.products.isEmpty()) {
            statistic.append("Nothing bought");
        } else {
            List<String> productsNames = this.products.stream().
                    map(p -> p.getName()).collect(Collectors.toList());
        statistic.append(String.join(", ", productsNames));
        }
        return statistic.toString();
    }
}
