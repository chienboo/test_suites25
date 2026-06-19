package branch;

import static defect.InfoLeak.*;

/**
 * condition for default branch of switch statement
 */
public class C03 {
    public static void main(String[] args) {
        C03 c03 = new C03();
        c03.good();
    }

    public void good() {
        String source = "safe";
        int cond = randomInt();
        switch (cond) {
            case 1:
            case 2:
                break;
            default:
                source = source();
        }
        if (cond == 2 || cond == 1) {
            sink(source);
        }
    }
}
