package inter;

import defect.InfoLeak;

public class C01 {

    public static void entry() {
//        C01 c01 = new C01();
//        c01.good();
//        c01.bad();
    }

    private void f(int x, String s) {
        if (x < -1) {
            InfoLeak.sink(s);
        } else {
            s = InfoLeak.safe();
        }
        g(x, s);
    }

    private void g(int x, String s) {
        if (x < 5) {
            InfoLeak.sink(s);
        }
    }

    private void good() {
        String s = InfoLeak.source();
        f(3, s);
    }

    private void bad() {
        String s = InfoLeak.source();
        f(-2, s);
    }
}
