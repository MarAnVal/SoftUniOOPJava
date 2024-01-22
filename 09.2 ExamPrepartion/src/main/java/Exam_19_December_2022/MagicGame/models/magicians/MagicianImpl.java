package main.java.Exam_19_December_2022.MagicGame.models.magicians;


import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;

import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {
    //· username - String
    private String username;
    //· health - int
    private int health;
    // · protection - int
    private int protection;
    // · isAlive - boolean
    private boolean isAlive;
    // · magic - Magic
    private Magic magic;

    //(String username, int health, int protection, Magic magic)
    public MagicianImpl(String username, int health, int protection, Magic magic) {
        // If the username is null or whitespace,
        // throw a NullPointerException with a message: "Username cannot be null or empty."
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
        // If the health is below 0,
        // throw an IllegalArgumentException with a message: "Magician health cannot be below 0."
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
        // If the protection is below 0,
        // throw an IllegalArgumentException with a message: "Magician protection cannot be below 0."
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
        // If the health is above zero.
        this.isAlive = health > 0;
        // If the magic object is null,
        // throw a NullPointerException with a message: "Magic cannot be null."
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        //The takeDamage() method decreases the Magician's protection and health.
        // First, you need to reduce the protection. If the protection reaches 0,
        this.protection -= points;
        if (this.protection < 0) {
            // transfer the damage to health points. If the health points are
            this.health += this.protection;
            this.protection = 0;
        }
        if (this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
        }
        // less than or equal to zero, the magician is dead.
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        //"{magician type}: {magician username}"
        text.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()));
        text.append(System.lineSeparator());
        //" Health: {magician health}"
        text.append(String.format("Health: %d",this.getHealth()));
        text.append(System.lineSeparator());
        //" Protection: {magician protection}"
        text.append(String.format("Protection: %d", this.getProtection()));
        text.append(System.lineSeparator());
        //" Magic: {magician magic name}"
        text.append(String.format("Magic: %s", this.getMagic().getName()));
        return text.toString();
    }
}
