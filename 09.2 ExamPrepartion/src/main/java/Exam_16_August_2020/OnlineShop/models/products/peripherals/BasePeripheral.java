package main.java.Exam_16_August_2020.OnlineShop.models.products.peripherals;

import main.java.Exam_16_August_2020.OnlineShop.models.products.BaseProduct;

import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.PERIPHERAL_TO_STRING;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    //connectionType – String
    private String connectionType;

    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }


    @Override
    public String toString() {
        //"Overall Performance: {overall performance}. Price: {price} - {product type}:
        // {manufacturer} {model} (Id: {id}) Connection Type: {connection type}"
        return String.format("%s%s",super.toString(),
                String.format(PERIPHERAL_TO_STRING, connectionType));
    }

    @Override
    public String getConnectionType() {
        return this.connectionType;
    }
}
