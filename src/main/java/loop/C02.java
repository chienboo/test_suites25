package loop;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
//        good();
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
}
