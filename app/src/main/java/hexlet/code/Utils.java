package hexlet.code;

import java.util.Random;

public class Utils {

    private static final Random RAND = new Random();
    public static int randInt(int stop) {
        return RAND.nextInt(stop);
    }

    public static int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
