package defect;

import java.util.Random;

public class InfoLeak {
    public static String source() {
        return "source";
    }
    public static void sink(String s) {
        System.out.println(s);
    }

    public static String safe() {
        return null;
    }

    static Random random = new Random();

    public static int randomInt() {
        return random.nextInt();
    }
    public static short randomShort() {
        int randomInt = random.nextInt(Short.MAX_VALUE - Short.MIN_VALUE + 1) + Short.MIN_VALUE;
        return (short) randomInt;
    }
    public static double randomDouble() {
        return random.nextDouble();
    }

    public static float randomFloat() {
        return random.nextFloat();
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }
}
