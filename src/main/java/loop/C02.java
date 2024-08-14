package loop;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
       good();
       bad();
    }

    private static void good() {
        String s = InfoLeak.source();
        int p = 0;
        for (p = 0; p < 10; ++p) {
            if (p > 5) {
                break;
            }
        }
        if (p < 3) {
            InfoLeak.sink(s);
        }
    }

    private static void bad() {
        String s = InfoLeak.source();
        int p = 0;
        for (p = 0; p < 10; ++p) {
            if (p > 5) {
                break;
            }
        }
        if (p >= 3) {
            InfoLeak.sink(s);
        }
    }
}
