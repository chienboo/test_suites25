package fields;

import static defect.InfoLeak.*;

/**
 * read/write a field through get/set method, use field in condition
 */
public class C08 {
    public static void main(String[] args) {
        C08 c08 = new C08();
        c08.good();
    }

    static class C {
        boolean x;
        boolean getX() {
            return x;
        }
        void setX(boolean x) {
            this.x = x;
        }
    }

    public void good() {
        boolean cond = randomBoolean();
        C c = new C();
        String source = "safe";
        if (!cond) {
            source = source();
        }
        c.setX(cond);
        if (c.getX()) {
            sink(source);
        }
    }
}
