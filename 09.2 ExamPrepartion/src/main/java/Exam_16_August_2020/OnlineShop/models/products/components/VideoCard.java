package main.java.Exam_16_August_2020.OnlineShop.models.products.components;

public class VideoCard extends BaseComponent {
    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance*1.15, generation);
    }
}
