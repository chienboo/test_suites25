package fields;

import defect.InfoLeak;

/**
 * condition is derived from computation of two fields
 */
public class C02 {
    public static void entry() {
       good();
       bad();
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
    
    private static void bad() {
        String s = InfoLeak.source();
        A a = new A();
        A b = new A();
        a.x = 5;
        b.x = 6;
        if (a.x + b.x < 20) {
            InfoLeak.sink(s);
        }
    }
}
