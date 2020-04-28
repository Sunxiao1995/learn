package club.banyuan;

import java.util.Random;

public class Level {
    private static int levelLowCount;
    private static int levelMiddleCount;
    private static int levelHighCount;

    private static void SetLevelLowCount() {
        Random randomOne = new Random();
        levelLowCount = randomOne.nextInt(10);

    }

    private static void setLevelMiddleCount() {
        Random randomTwo = new Random();
        levelMiddleCount = randomTwo.nextInt(100);

    }

    private static void setLevelHighCount() {
        Random randomThree = new Random();
        levelHighCount = randomThree.nextInt(1000);

    }


    public static int getLevelLowCount() {
        SetLevelLowCount();
        return levelLowCount;
    }

    public static int getLevelMiddleCount() {
        setLevelMiddleCount();
        return levelMiddleCount;
    }

    public static int getLevelHighCount() {
        setLevelHighCount();
        return levelHighCount;
    }

}


  