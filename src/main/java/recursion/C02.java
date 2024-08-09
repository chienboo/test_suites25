package recursion;

import defect.InfoLeak;

public class C02 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int p = g(3);
        if (p > 15) {
            InfoLeak.sink(s);
        }
    }

    private static int f(int n) {
        if (n <= 0)
            return 2;
        return g(n - 1) + n;
    }

    private static int g(int n) {
        if (n <= 0)
            return 1;
        return f((n + 1) / 2) * n;
    }

    public static void main(String[] args) {
        int p = g(3);
        System.out.println(p);
    }
}
