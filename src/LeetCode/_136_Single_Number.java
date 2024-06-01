package LeetCode;

import java.util.Arrays;

public class _136_Single_Number {
    public static void main(String[] args) {
        System.out.println(new Solution136().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Solution136().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new Solution136().singleNumber(new int[]{1}));

    }


}

class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != nums[i + 1] && nums[i + 1] != nums[i + 2]) {
                return nums[i + 1];
            }
        }
        return nums[nums.length - 1];
    }
}