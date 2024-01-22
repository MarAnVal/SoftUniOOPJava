package main.java.Exam_19_December_2022.MagicGame.models.magics;


import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT;
import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.INVALID_MAGIC_NAME;

public abstract class MagicImpl implements Magic{
    //name – String
    private String name;
    //· bulletsCount – int
    private int bulletsCount;

    //(String name, int bulletsCount)

    public MagicImpl(String name, int bulletsCount) {
        //o If the name is null or whitespace,
        // throw a NullPointerException with a message: "Magic cannot be null or empty."
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }
        this.name = name;
        //o If the bullets count is below zero,
        // throw an IllegalArgumentException with a message: "Bullets cannot be below 0."
        if(bulletsCount<0){
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        //The fire() method fires the number of bullets the Magic has and reduces its available amount.
        // RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
        // If there are not enough bullets, the method should return 0.
        int numberOfUsedBullets = 1;
        if(this.bulletsCount < numberOfUsedBullets){
            return 0;
        }
        this.bulletsCount-=numberOfUsedBullets;
        return numberOfUsedBullets;
    }
}
