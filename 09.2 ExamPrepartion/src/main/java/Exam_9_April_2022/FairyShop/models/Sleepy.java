package main.java.Exam_9_April_2022.FairyShop.models;

public class Sleepy extends BaseHelper{
    private int energy;
    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        this.energy -= 15;
        if (this.energy < 0){
            this.energy = 0;
        }
    }
}
