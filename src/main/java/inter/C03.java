package inter;

import defect.InfoLeak;

public class C03 {
    static class C {
        int x;
        String s;
    }
    public static void entry(int anyInt, boolean anyBool) {
//        C03 c03 = new C03();
//        c03.good(anyInt);
    }

    private void good(int i) {
        C a = new C();
        C b = a;
        if (i > 0) {
            a.s = InfoLeak.source();
            a.x = i;
        }
        reachSink(b);
    }

    private void reachSink(C c) {
        if (c.x < 0) {
            InfoLeak.sink(c.s);
        }
    }
}
