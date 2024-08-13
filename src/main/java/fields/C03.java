package fields;

import defect.InfoLeak;

/**
 * a field may point-to two heap objects
 */
public class C03 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        A a = new A();
        A b = new A();
        a.x = 5;
        b.x = 6;
        boolean cond = InfoLeak.randomBoolean();
        A c = cond ? a : b;
        if (c.x > 20) {
            InfoLeak.sink(s);
        }
    }
}
