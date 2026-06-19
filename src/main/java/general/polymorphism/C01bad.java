package general.polymorphism;

import static defect.InfoLeak.sink;
import static defect.InfoLeak.source;

/**
 * interface invoke, bad case
 */
public class C01bad {
    public static void main(String[] args) {
        C01bad c02 = new C01bad();
        c02.good();
    }

    public void good() {
        I caller = new A();
        int x = 0;
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
