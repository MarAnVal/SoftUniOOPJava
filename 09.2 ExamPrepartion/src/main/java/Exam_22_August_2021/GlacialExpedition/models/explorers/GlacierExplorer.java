package main.java.Exam_22_August_2021.GlacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    public GlacierExplorer(String name) {
        super(name, 40);
    }

    @Override
    public void search() {
        for (int i = 0; i < 15; i++) {
            super.search();
        }

    }
}
