package LeetCode;

import java.util.Arrays;

public class _69_Sqrt_x_ {
    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt2(35));
    }
}

class Solution69 {
    public int mySqrt(int x) {
        long i = 0;
        while (true) {
            i++;
            if ((i * i) > x) {
                return (int) i - 1;
            }
        }
    }

    // others code
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;

        int start = 0;
        int end = x;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((long) mid * mid > (long) x) end = mid - 1;
            else if (mid * mid == x) return mid;
            else start = mid + 1;
        }
        return Math.round(end);
    }
}