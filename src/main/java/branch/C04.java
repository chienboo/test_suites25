package branch;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * Phi nodes of else if
 */
public class C04 {
    public static void entry(boolean a, boolean b) {
        C04 c04 = new C04();
        c04.good(a, b);
    }

    public void good(boolean a, boolean b) {
        String source = "safe";
        if (a) {
            source = "a";
        } else if (b) {
            source = source();
        }
        // source condition: !a /\ b
        if (a) {
            sink(source);
        }

        if (!b) {
            sink(source);
        }
    }
}
