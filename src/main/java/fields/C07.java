package fields;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * use field of parameter in condition
 */
public class C07 {
    public static void main(String[] args) {
        C07 c07 = new C07();
        c07.good();
    }

    public void good() {
        A a = new A();
        a.x = 0;
        reachSink(a);
    }

    public void reachSink(A a) {
        String source = source();
        if (a.x != 0) {
            sink(source);
        }
    }
}
