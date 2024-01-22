package main.java.Exam_11_December_2021.CatHouse.entities.cat;

public class LonghairCat extends BaseCat {
    //Can only live in LongHouse!
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, 9, price);
    }

    @Override
    public void eating() {
        for (int i = 0; i < 3; i++) {
            super.eating();
        }
    }
}
