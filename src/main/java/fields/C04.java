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
        c04.bad();
    }
    private Inner inner = new Inner();

    public void good() {
        String source = source();
        setCond();
        if (inner.cond) {
            sink(source);
        }
    }

    public void bad() {
        String source = source();
        turnOn();
        if (inner.cond) {
            sink(source);
        }
    }

    public void setCond() {
        inner.cond = false;
    }

    public void turnOn() {
        inner.cond = true;
    }

    static class Inner {
        boolean cond;
    }
}
