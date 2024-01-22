package main.java.Exam_22_August_2021.GlacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    public AnimalExplorer(String name) {
        super(name, 100);
    }

    @Override
    public void search() {
        for (int i = 0; i < 15; i++) {
            super.search();
        }
    }
}
