package fields;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        A a = new A();
        A b = new A();
        a.x = 5;
        b.x = 6;
        if (a.x + b.x > 20) {
            InfoLeak.sink(s);
        }
    }
}
