package inter;

import defect.InfoLeak;

/**
 * todo: redundant to C01?
 */
public class C04 {
    public static void entry() {
        C04 c04 = new C04();
        // c04.good();
        // c04.bad();
    }

    private String f(int x) {
        String s;
        if (x < -1) {
            return InfoLeak.source();
        } else {
            s = InfoLeak.safe();
        }
        return g(x, s);
    }

    private String g(int x, String s) {
        if (x < 5) {
            return InfoLeak.source();
        }
        return InfoLeak.safe();
    }

    private void good() {
        String s = f(6);
        InfoLeak.sink(s);
    }

    private void bad() {
        String s = f(3);
        InfoLeak.sink(s);
    }

}
