package branch;

import static defect.InfoLeak.*;

/**
 * Ternary operator
 */
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        c05.bad();
        c05.good();
    }

    public void good() {
        boolean cond = randomBoolean();
        String source = cond ? source() : "safe";
        if (!cond) {
            sink(source);
        }
    }

    public void bad() {
        boolean cond = randomBoolean();
        String source = cond ? source() : "safe";
        if (cond) {
            sink(source);
        }
    }
}
