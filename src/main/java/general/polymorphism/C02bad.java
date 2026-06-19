package general.polymorphism;

import static defect.InfoLeak.*;

/**
 * condition comes from super method, good case
 */
public class C02bad {
    public static void main(String[] args) {
        B b = new B();
        b.bad();
    }

    static class A {
        boolean cond(boolean cond) { return !cond; }
    }

    static class B extends A {
        public void bad() {
            boolean cond = randomBoolean();
            String source = cond ? safe() : source();
            cond = super.cond(cond);
            if (cond) {
                sink(source);
            }
        }
    }
}
