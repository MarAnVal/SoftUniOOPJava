package main.java.Exam_19_December_2022.MagicGame.models.magics;

public class BlackMagic extends MagicImpl{
    private int bulletsCount;

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
        this.bulletsCount = bulletsCount;
    }

    @Override
    public int fire() {
        //The fire() method fires the number of bullets the Magic has and reduces its available amount.
        // RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
        // If there are not enough bullets, the method should return 0.
        int numberOfUsedBullets = 10;
        if(this.bulletsCount < numberOfUsedBullets){
            return 0;
        }
        this.bulletsCount-=numberOfUsedBullets;
        return numberOfUsedBullets;
    }
}
