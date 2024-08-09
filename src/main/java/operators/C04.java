package operators;

import defect.InfoLeak;

public class C04 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int a = InfoLeak.randomInt();
        int b = InfoLeak.randomInt();
        int c = (a - b) * (a + b);
        int d = a & c;
        int e = c | d;
        int f = a % b;
        f = ~f;

        boolean result = (-e + f >= 1) && (-e - f >= 1) && e >= 0 && f >= 0 && e <= 100 && f <= 100;

        if (result) {
            InfoLeak.sink(s);
        }

    }

    private static void bad() {
        String s = InfoLeak.source();
        int a = InfoLeak.randomInt();
        int b = InfoLeak.randomInt();
        int c = InfoLeak.randomInt();
        int d = InfoLeak.randomInt();
        int e = InfoLeak.randomInt();
        int f = InfoLeak.randomInt();

        boolean result = ((a - b) * (c + d) > (e / f)) && ((a % b) == (c & d)) && ((a | b) != (c ^ d)) && ((a * b) == (c - d));
        if (result) {
            InfoLeak.sink(s);
        }
    }

    public static void main(String[] args) {
        entry();
    }
}
