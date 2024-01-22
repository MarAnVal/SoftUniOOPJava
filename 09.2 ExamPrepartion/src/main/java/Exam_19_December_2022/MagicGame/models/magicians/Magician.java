package main.java.Exam_19_December_2022.MagicGame.models.magicians;

import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
