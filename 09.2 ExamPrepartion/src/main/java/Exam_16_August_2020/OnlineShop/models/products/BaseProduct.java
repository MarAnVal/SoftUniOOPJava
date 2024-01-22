package main.java.Exam_16_August_2020.OnlineShop.models.products;

import static main.java.Exam_16_August_2020.OnlineShop.common.constants.ExceptionMessages.*;
import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public abstract class BaseProduct implements Product {
    //id – int
    private int id;
    private String manufacturer;
    //model – String
    private String model;
    //price – double
    private double price;
    //overallPerformance – double
    private double overallPerformance;


    public BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        //cannot be less than or equal to 0. In that case,
        // throw IllegalArgumentException with the message "Id can not be less or equal than 0."
        if (id <=0){
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
        //cannot be null or whitespace. In that case,
        // throw IllegalArgumentException with the message "Manufacturer can not be empty."
        if(manufacturer==null||manufacturer.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
        //cannot be null or whitespace. In that case,
        // throw IllegalArgumentException with the message "Model can not be empty."
        if(model==null||model.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
        //cannot be less than or equal to 0. In that case,
        // throw IllegalArgumentException with the message "Price can not be less or equal than 0."
        if (price<=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
        //cannot be less than or equal to 0. In that case,
        // throw IllegalArgumentException with the message "Overall Performance can not be less or equal than 0."
        if(overallPerformance<=0){
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    @Override
    public String toString() {
        //Override toString() method in the format:
        //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"
        return String.format(PRODUCT_TO_STRING,
                this.getOverallPerformance(),
                this.getPrice(),
                this.getClass().getSimpleName(),
                this.getManufacturer(),
                this.getModel(),
                this.getId());
    }
}
