package LeetCode;

import java.util.List;

public class _231_Power_of_Two {
    public static void main(String[] args) {
        System.out.println((int) Math.pow(2, 31) - 1);
        System.out.println(new Solution231().isPowerOfTwo(2));

    }
}

class Solution231 {
    // mycode
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        List<Integer> listPlus = List.of(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824);
        return listPlus.contains(n);
    }

    // others code
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}