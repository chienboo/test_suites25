package fields;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * use field of this object in condition
 */
public class C06 {
    boolean cond;

    public static void main(String[] args) {
        C06 c06 = new C06();
        c06.good();
    }

    public void good() {
        this.cond = false;
        reachSink();
    }

    public void reachSink() {
        String source = source();
        if (this.cond) {
            sink(source);
        }
    }
}
