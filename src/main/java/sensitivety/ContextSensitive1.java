package sensitivety;

import defect.InfoLeak;

import static defect.InfoLeak.*;

/**
 * call-site context sensitive case1
 */
public class ContextSensitive1 {
    public static void main(String[] args) {
        ContextSensitive1 cs1 = new ContextSensitive1();
        cs1.good();
        cs1.bad();
    }

    static class A {
        public int wrapper(int x) {
            return id(x);
        }

        public int id(int x) { return x; }
    }

    public void good() {
        A a = new A();
        int x = randomInt();
        String source = safe();
        if (a.wrapper(0) == 1) {
            source = InfoLeak.source();
        }
        if (a.wrapper(x) == x) {
            sink(source);
        }
    }

    public void bad() {
        A a = new A();
        int x = randomInt();
        String source = safe();
        if (a.wrapper(0) == 0) {
            source = InfoLeak.source();
        }
        if (a.wrapper(x) == x) {
            sink(source);
        }
    }
}
