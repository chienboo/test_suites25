package general.polymorphism;

import static defect.InfoLeak.*;

/**
 * Override cases (good)
 */
public class C03 {
    public static void main(String[] args) {
        C03 c03 = new C03();
        boolean cond = randomBoolean();
        c03.good(cond);
        c03.bad(cond);
    }

    public void good(boolean cond) {
        A a = new A();
        B b = new B();
        String source = safe();
        if (a.cond(cond)) {
            source = source();
        }
        if (b.cond(cond)) {
            sink(source);
        }
    }

    public void bad(boolean cond) {
        A a = new A();
        B b = new B();
        String source = safe();
        if (a.cond(cond)) {
            source = source();
        }
        if (b.cond(!cond)) {
            sink(source);
        }
    }

    static class A {
        boolean cond(boolean b) { return b; }
    }

    static class B extends A {
        @Override
        boolean cond(boolean b) { return !b; }
    }
}
