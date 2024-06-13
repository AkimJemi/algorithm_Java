package LeetCode;

import java.util.Arrays;

public class _523_Continuous_Subarray_Sum {
    public static void main(String[] args) {
        System.out.println(new Solution523().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 5));
    }
}

class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; i++) {

            }
        }
        return true;
    }
}