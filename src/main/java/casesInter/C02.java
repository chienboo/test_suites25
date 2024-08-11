package casesInter;

import defect.InfoLeak;

public class C02 {
    static class C {
        int x;
        String s;
    }
    public static void entry(int anyInt, boolean anyBool) {
        // C02 c02 = new C02();
        // C a = new C();
        // C b = new C();
        // if (anyInt > 0) {
        //     a.s = InfoLeak.source();
        //     a.x = 0;
        // }
        // b.s = InfoLeak.safe();
        // b.x = anyInt;
        // C c = anyInt > 0 ? a : b;
        // c02.reachSink(c);
    }

    private void reachSink(C c) {
        if (c.x > 0) {
            InfoLeak.sink(c.s);
        }
    }
}
