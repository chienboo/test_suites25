package inter;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * use return value in condition
 */
public class C07 {
    public static void main(String[] args) {
        C07 c07 = new C07();
        c07.good();
    }

    public int addOne(int x) {
        return x + 1;
    }

    public void good() {
        int x = 0;
        String source = source();
        if (addOne(x) != 1) {
            sink(source);
        }
    }
}
