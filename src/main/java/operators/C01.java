package operators;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
       good();
    }

    private static void good() {
        String s = InfoLeak.source();
        boolean a = InfoLeak.randomBoolean();
        boolean b = InfoLeak.randomBoolean();
        boolean cond1 = a && b;
        boolean cond2 = !(a || b);
        boolean result = and(cond1, cond2);
        if (result) {
            InfoLeak.sink(s);
        }
    }

    private static boolean and(boolean a, boolean b) {
        return a && b;
    }

}
