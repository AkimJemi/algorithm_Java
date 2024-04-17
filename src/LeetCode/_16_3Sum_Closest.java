package LeetCode;

import java.util.Arrays;

public class _16_3Sum_Closest {
    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{0, 1, 2, 5}, 6));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 2;
        int j = 1;
        int n = 0;
        while (target >= nums[i] + nums[j] + nums[n]) {
            if (nums.length == i + 1) {
                break;
            }
            i++;
        }
        while (target >= nums[i] + nums[++j] + nums[n]) {
        }
        j--;
        while (target >= nums[i] + nums[j] + nums[++n]) {
        }
        n--;
        return nums[i] + nums[j] + nums[n];
    }
}