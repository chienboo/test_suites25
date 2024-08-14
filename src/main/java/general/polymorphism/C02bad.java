package general.polymorphism;

import static defect.InfoLeak.*;
import static defect.InfoLeak.sink;

/**
 * condition comes from super method, bad case
 */
public class C02bad {
    public static void main(String[] args) {
        B b = new B();
        b.good();
    }

    static class A {
        boolean cond(boolean cond) { return cond; }
    }

    static class B extends A {
        public void good() {
            boolean cond = randomBoolean();
            String source = cond ? safe() : source();
            cond = super.cond(cond);
            if (cond) {
                sink(source);
            }
        }
    }
}
