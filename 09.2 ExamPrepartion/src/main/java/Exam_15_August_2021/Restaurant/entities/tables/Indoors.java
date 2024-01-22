package main.java.Exam_15_August_2021.Restaurant.entities.tables;

public class Indoors extends BaseTable{
    //constant value for pricePerPerson - 4.50
    private static final double INDOORS_PRICE_PER_PERSON = 3.5;

    public Indoors(int number, int size) {
        super(number, size, INDOORS_PRICE_PER_PERSON);
    }
}
