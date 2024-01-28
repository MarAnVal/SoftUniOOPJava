package main.java.Exam_19_December_2022.MagicGame.core;

public interface Controller {
    String addMagic(String type, String name, int bulletsCount);

    String addMagician(String type, String username, int health, int protection, String magicName);

    String startGame();

    String report();
}

