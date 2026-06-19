package inter;

import defect.InfoLeak;

public class C02 {
    static class C {
        int x;
        String s;
    }
    public static void entry(int anyInt) {
        C02 c02 = new C02();
        c02.bad(anyInt);
        c02.good(anyInt);
    }
    
    private void bad(int i) {
        C a = new C();
        C b = new C();
        if (i > 0) {
            a.s = InfoLeak.source();
            a.x = 1;
        }
        b.s = InfoLeak.safe();
        b.x = i;
        C c = i > 0 ? a : b;
        reachSink(c);
    }

    private void good(int i) {
        C a = new C();
        C b = new C();
        if (i > 0) {
            a.s = InfoLeak.source();
            a.x = 0;
        }
        b.s = InfoLeak.safe();
        b.x = i;
        C c = i <= 0 ? a : b;
        reachSink(c);
    }


    private void reachSink(C c) {
        if (c.x > 0) {
            InfoLeak.sink(c.s);
        }
    }
}
