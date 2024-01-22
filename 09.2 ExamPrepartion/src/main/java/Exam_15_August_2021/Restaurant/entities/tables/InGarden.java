package main.java.Exam_15_August_2021.Restaurant.entities.tables;

public class InGarden extends BaseTable{
    //constant value for pricePerPerson - 4.50
    private static final double INGARDEN_PRICE_PER_PERSON = 4.5;
    public InGarden(int number, int size) {
        super(number, size, INGARDEN_PRICE_PER_PERSON);
    }
}
