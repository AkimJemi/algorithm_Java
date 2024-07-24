package LeetCode;

import java.sql.Struct;

public class _268_Missing_Number {
    public static void main(String[] args) {
        System.out.println(new Solution268().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new Solution268().missingNumber(new int[]{0, 1}));
        System.out.println(new Solution268().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

    }
}

class Solution268 {
    // mycode
    public int missingNumber(int[] nums) {
        int[] array = new int[nums.length + 1];
        for (int num : nums) array[num]++;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                return i;
            }
        }
        return nums.length;
    }

    // others code
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int actualsum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return actualsum - sum;
    }
}