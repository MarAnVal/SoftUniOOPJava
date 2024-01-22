package main.java.Exam_16_August_2020.OnlineShop.models.products.components;

public class CentralProcessingUnit extends BaseComponent {

    public CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.25, generation);
    }
}
