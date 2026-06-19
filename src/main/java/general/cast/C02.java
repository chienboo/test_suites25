package general.cast;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
       good();
    }

    private static void good() {
        String s = InfoLeak.source();
        double d = InfoLeak.randomDouble();
        if (d > -100. && d < 100.) {
            int p = (int) d;
            if (d < p - 1 || d > p + 1) {
                InfoLeak.sink(s);
            }
        }
    }
}
