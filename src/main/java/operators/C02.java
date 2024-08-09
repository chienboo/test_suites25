package operators;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        boolean a = InfoLeak.randomBoolean();
        boolean b = InfoLeak.randomBoolean();
        boolean c = InfoLeak.randomBoolean();

        boolean cond = ((a | b) & (!a | c)) & ((!b | !c) | (a & !c)) & (!a | b | !c) & (b & c);

        if (cond) {
            InfoLeak.sink(s);
        }
    }
}
