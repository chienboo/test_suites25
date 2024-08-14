package loop;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
       good();
       bad();
    }

    private static void good() {
        String s = InfoLeak.source();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        if (sum < 10) {
            InfoLeak.sink(s);
        }
    }

    private static void bad() {
        String s = InfoLeak.source();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        if (sum > 10) {
            InfoLeak.sink(s);
        }
    }
}
