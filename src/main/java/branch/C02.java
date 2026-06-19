package branch;

import static defect.InfoLeak.*;

/**
 * basic condition of case branch of switch statement
 */
public class C02 {

    public static void main(String[] args) {
        C02 c02 = new C02();
        c02.bad();
        c02.good();
    }

    public void bad() {
        int cond = randomInt();
        String source = "safe";
        switch (cond) {
            case 1:
                source = source();
                break;
            case 2:
                source = "2";
                break;
            default:
                break;
        }
        if (cond == 1) {
            sink(source);
        }
    }

    public void good() {
        int cond = randomInt();
        String source = "safe";
        switch (cond) {
            case 1:
                source = source();
                break;
            case 2:
                source = "2";
                break;
            default:
                break;
        }
        if (cond != 1) {
            sink(source);
        }
    }
}
