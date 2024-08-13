package fields;

import defect.InfoLeak;

/**
 * direct field access in if-condition
 */
public class C01 {
    public static void entry() {
       good();
    }

    private static void good() {
        String s = InfoLeak.source();
        A a = new A();
        a.x = 0;
        if (a.x > 10) {
            InfoLeak.sink(s);
        }
    }
}
