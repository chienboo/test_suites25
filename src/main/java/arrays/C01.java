package arrays;

import defect.InfoLeak;

public class C01 {
    public static void entry() {
//        good();
    }

    private static void good() {
        String s = InfoLeak.source();
        int[] arr = new int[] {1, 2, 3, 4};
        if (arr[getIndex()] == 2) {
            InfoLeak.sink(s);
        }
    }

    private static int getIndex() {
        return 0;
    }
}
