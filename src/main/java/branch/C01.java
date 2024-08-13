package branch;

import defect.InfoLeak.*;

import static defect.InfoLeak.*;

/**
 * shortcut evaluation test
 */
public class C01 {

    public static void main(String[] args) {
        C01 c01 = new C01();
        c01.good();
    }

    public void bad1() {
        boolean a = randomBoolean();
        boolean b = randomBoolean();
        String source = "safe";
        if (a || b) {
            source = source();
        }
        if (!a) {
            sink(source);
        }
    }

    public void bad2() {
        boolean a = randomBoolean();
        boolean b = randomBoolean();
        String source = "safe";
        if (a || b) {
            source = source();
        }
        if (!b) {
            sink(source);
        }
    }

    public void good() {
        boolean a = randomBoolean();
        boolean b = randomBoolean();
        String source = safe();
        if (a || b) {
            source = source();
        }
        if (!a && !b) {
            sink(source);
        }
    }
}
