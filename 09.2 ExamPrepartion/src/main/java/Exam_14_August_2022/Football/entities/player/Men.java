package main.java.Exam_14_August_2022.Football.entities.player;

public class Men extends BasePlayer {
    //??
    // can only play on NaturalGrass!

    public Men(String name, String nationality, int strength) {
        super(name, nationality, 85.5, strength);
    }

    @Override
    public void stimulation() {
        for (int i = 0; i < 145; i++) {
            super.stimulation();
        }
    }
}
