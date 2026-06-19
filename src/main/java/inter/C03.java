package inter;

import defect.InfoLeak;

public class C03 {
    static class C {
        int x;
        String s;

        void reachSink() {
            if (x < 0) {
                InfoLeak.sink(s);
            }
        }
    }
    public static void entry(int anyInt) {
        C03 c03 = new C03();
        c03.good(anyInt);
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
        b.reachSink();
    }
}
