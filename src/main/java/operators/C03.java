package operators;

import defect.InfoLeak;

public class C03 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();

        int a = InfoLeak.randomInt();
        int b = InfoLeak.randomInt();
        int c = InfoLeak.randomInt();
        int d = InfoLeak.randomInt();
        int e = InfoLeak.randomInt();

        boolean result = ((a > b) && (c < d) && (e >= 0)) && ((a <= b) && (c >= d) && (e < 0));

        if (result) {
            InfoLeak.sink(s);
        }
    }
}
