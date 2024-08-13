package loop;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
       good();
    }

    private static void good() {
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
