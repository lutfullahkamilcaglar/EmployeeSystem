package util;

import java.util.Random;

public class RandomManager {
    private final Random random = new Random();

    public int generateId() {
        return random.nextInt(1000 - 100) + 100;
    }
}
