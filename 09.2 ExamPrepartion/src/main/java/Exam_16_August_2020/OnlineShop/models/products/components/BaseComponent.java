package main.java.Exam_16_August_2020.OnlineShop.models.products.components;

import main.java.Exam_16_August_2020.OnlineShop.models.products.BaseProduct;

import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.COMPONENT_TO_STRING;

public abstract class BaseComponent extends BaseProduct implements Component {
    //generation – int
    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public String toString() {
        //"Overall Performance: {overall performance}.
        // Price: {price} - {product type}: {manufacturer} {model} (Id: {id}) Generation: {generation}"
        return String.format("%s%s",
                super.toString(),
                String.format(COMPONENT_TO_STRING, this.generation));
    }

    @Override
    public int getGeneration() {
        return this.generation;
    }
}
