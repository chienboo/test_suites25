package casesInter;

import defect.InfoLeak;

public class C06 {
    static class C {
        int x;
        String s;
    }
    public static void entry(int anyInt) {
        C06 c06 = new C06();
        c06.good(anyInt);
    }

    private void foo(C c) { 
        int x = c.x + 3;
        System.out.println(x);
    }

    private void good(int i) {
        C a = new C();
        C b = a;
        if (i > 0) {
            a.s = InfoLeak.source();
            a.x = i;
        }
        foo(a);
        reachSink(b);
    }

    private void reachSink(C c) {
        if (c.x < 0) {
            InfoLeak.sink(c.s);
        }
    }
}
