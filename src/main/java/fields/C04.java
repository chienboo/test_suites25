package fields;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * use static field as condition
 */
public class C04 {
    public static void main(String[] args) {
        C04 c04 = new C04();
        c04.good();
    }

    public void good() {
        String source = source();
        setCond();
        if (Inner.cond) {
            sink(source);
        }
    }

    public void setCond() {
        Inner.cond = false;
    }

    static class Inner {
        static boolean cond;
    }
}
