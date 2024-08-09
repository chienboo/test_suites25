package operators;

import defect.InfoLeak;

public class C05 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int x1 = InfoLeak.randomInt();
        int x2 = InfoLeak.randomInt();
        boolean result = (x1 - x2 >= 1) && (-x1 + x2 >= 1) && x1 >= 0 && x2 >= 0;
        if (result) {
            InfoLeak.sink(s);
        }
    }
}
