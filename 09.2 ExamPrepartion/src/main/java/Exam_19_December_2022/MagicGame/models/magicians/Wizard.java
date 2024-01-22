package main.java.Exam_19_December_2022.MagicGame.models.magicians;
import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;

public class Wizard extends MagicianImpl{
    //(String username, int health, int protection, Magic magic)
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
