package recursion;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
       good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int p = f(3);
        if (p > 10) {
            InfoLeak.sink(s);
        }
    }

    private static int f(int n) {
        if (n <= 0)
            return 0;
        return f(n - 1) + n;
    }
}
