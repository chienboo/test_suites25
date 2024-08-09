package cast;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int d = InfoLeak.randomInt();
        boolean c1 = d > 32700;
        boolean c2 = d < 32710;
        boolean cond = c1 && c2;
        if (cond) {
            short p = (short) (d * 2);
            if (p > 135.) {
                InfoLeak.sink(s);
            }
        }
    }
}
