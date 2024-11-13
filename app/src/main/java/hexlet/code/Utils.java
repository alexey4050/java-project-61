package hexlet.code;

import java.util.Random;

public class Utils {

    static final int MIN_RANDOM_NUMBER = 0;
    static final int MAX_RANDOM_NUMBER = 100;

    private static final Random RANDOM = new Random();

    public static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        return lowerRangeLimit + RANDOM.nextInt(upperRangeLimit - lowerRangeLimit);
    }

    public static int generateRandomNumber() {
        return generateRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
