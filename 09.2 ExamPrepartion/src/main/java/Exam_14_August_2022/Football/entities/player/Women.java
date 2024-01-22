package main.java.Exam_14_August_2022.Football.entities.player;

public class Women extends BasePlayer {
    //??
    // can only play on ArtificialTurf!

    public Women(String name, String nationality, int strength) {
        super(name, nationality, 60, strength);
    }

    @Override
    public void stimulation() {
        for (int i = 0; i < 115; i++) {
            super.stimulation();
        }
    }
}
