package LeetCode;

import java.util.Arrays;

public class _338_Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_338_Counting_Bits().countBits(5)));
    }
}

class Solution_338_Counting_Bits {
    public int[] countBits(int n) {
        int[] array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String tmp = Integer.toBinaryString(i);
            int count = tmp.replace("0", "").length();
            array[i] = count;
        }
        return array;

    }

    // others code
    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        rec(dp, 1, 1);
        return dp;
    }

    void rec(int[] dp, int index, int ones) {
        if (index >= dp.length) return;
        dp[index] = ones;

        rec(dp, index * 2, ones);
        rec(dp, index * 2 + 1, ones + 1);
    }

    public int[] countBits3(int n) {
        if (n == 0)
            return new int[]{0};
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int pow;
        for (int pwr = 1; Math.pow(2, pwr) <= n; pwr++) {
            pow = (int) Math.pow(2, pwr);
            for (int i = 0; i < pow && pow + i <= n; i++) {
                arr[pow + i] = 1 + arr[i];
            }
        }
        return arr;
    }
}