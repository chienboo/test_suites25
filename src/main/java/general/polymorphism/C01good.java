package general.polymorphism;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * interface invoke
 */
public class C01good {
    public static void main(String[] args) {
        C01good c01 = new C01good();
        c01.good();
    }

    public void good() {
        I caller = new A();
        int x = 1;
        String source = source();
        if (caller.cond(x)) {
            sink(source);
        }
    }

    interface I {
        boolean cond(int x);
    }

    static class A implements I {
        @Override
        public boolean cond(int x) {
            return x == 0;
        }
    }
}
