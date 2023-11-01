package hexlet.code;

import java.util.Random;

public class Utils {

    private static final Random RAND = new Random();
    public static int randInt(int stop) {
        return RAND.nextInt(stop);
    }
    public static int randInt(int start, int stop) {
        if (start >= stop) {
            return RAND.nextInt(stop);
        }

        int result = RAND.nextInt(stop);
        while (result < start) {
            result = randInt(stop);
        }
        return result;
    }
}
