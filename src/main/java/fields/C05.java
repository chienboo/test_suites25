package fields;

import static defect.InfoLeak.*;

/**
 * multistep ap access
 */
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        c05.good();
    }

    public void good() {
        boolean cond = randomBoolean();
        String source = "safe";
        if (!cond) {
            source = source();
        }
        A a = new A();
        a.b = new B(cond);
        if (a.b.x) {
            sink(source);
        }
    }

    static class A {
        B b;
    }

    static class B {
        boolean x;

        public B(boolean x) {
            this.x = x;
        }
    }
}
