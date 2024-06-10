package LeetCode;

import java.util.Arrays;

public class _1051_Height_Checker {
    public static void main(String[] args) {
        System.out.println(new Solution1051().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));

    }
}

class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        int count = 0;
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) count++;
        }
        return count;
    }
}