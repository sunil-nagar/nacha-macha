package nm.utils;

import java.util.Random;

public class RandomException {

    public static void randomReject() throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(1, 20 + 1);
        if (randomNumber < 3)
            throw new Exception("RandomRejectionException :-)");
    }

}
