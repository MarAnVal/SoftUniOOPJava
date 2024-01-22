package main.java.Exam_22_August_2021.GlacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public NaturalExplorer(String name) {
        super(name, 60);
    }

    @Override
    public void search() {
        for (int i = 0; i < 7; i++) {
            super.search();
        }
    }
}
