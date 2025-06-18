package Study.algorithm;

import java.util.Arrays;

public class Karatsuba {
    public static void main(String[] args) {
        Integer a = 50220;
        System.out.println(sumArrayValue(toMakeIntArray(1, 2, 3), toMakeIntArray(1, 2, 555)));
    }

    static int sumArrayValue2(Integer[]... arrays) {
        return Arrays.stream(arrays).mapToInt(a -> Arrays.stream(a).reduce(Integer::sum).orElse(0)).sum();
    }

    static int sumArrayValue(Integer[]... arrays) {
        return Arrays.stream(arrays).flatMap(Arrays::stream).mapToInt(Integer::intValue).sum();
    }

    static Integer[] toMakeIntArray(Integer... vals) {
        return vals;
    }
}
