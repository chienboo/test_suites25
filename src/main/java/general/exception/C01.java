package general.exception;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * source inside catch block, while the condition of sink requires no exception throw
 */
public class C01 {
    public static void main(String[] args) {
        C01 c01 = new C01();
        c01.good(3);
        c01.bad(0);
    }

    public void good(int x) {
        String source = "";
        int[] a = new int[2];
        boolean cond = true;
        try {
            a[x] = a[0];
        } catch (IndexOutOfBoundsException e) {
            source = source();
            cond = false;
        }

        if (cond) {
            sink(source);
        }
    }

    public void bad(int x) {
        String source = "";
        int[] a = new int[2];
        boolean cond = true;
        try {
            a[x] = a[0];
            source = source();
        } catch (IndexOutOfBoundsException e) {
            cond = false;
        }
        if (cond) {
            sink(source);
        }
    }
}
