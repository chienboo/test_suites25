package inter;

import static defect.InfoLeak.*;

/**
 * cd of sink in callee contradicts with the cd of call-site in caller
 */
public class C08 {
    public static void main(String[] args) {
        C08 c08 = new C08();
        c08.good();
    }

    public void good() {
        int cond = randomInt();
        String source = source();
        if (cond == 0) {
            reachSink(source, cond);
        }
    }

    private void reachSink(String source, int cond) {
        if (cond != 0) {
            sink(source);
        }
    }
}
