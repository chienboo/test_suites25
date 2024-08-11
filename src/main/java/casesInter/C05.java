package casesInter;

import defect.InfoLeak;

public class C05 {
    public static void entry() {
        C05 c05 = new C05();
//        c05.good();
    }

    private void good() {
        int i = InfoLeak.randomInt();
        int j = InfoLeak.randomInt();
        if (i < -2 && 2 <= j && j <= 3) {
            String s = b1(i);
            f1(j, s);
        }
    }

    private String b1(int x) {
        String s = null;

        if (x < -1) {
            s = InfoLeak.source();
            s = b2(s);
        } else {
            s = InfoLeak.safe();
        }
        if (x < 0) {
            s = InfoLeak.source();
        }
        s = b2(s);
        return s;
    }

    private String b2(String s) {
        String t = s;
        return t;
    }

    private void f1(int x, String s) {
        s = f2(s);
        if (x < 1) {
            InfoLeak.sink(s);
        } else {
            s = f2(s);
            if (x < 2)
                InfoLeak.sink(s);
            else
                s = InfoLeak.safe();
        }
    }

    private String f2(String s) {
        String y = s;
        return y;
    }

}
