package LeetCode;

public class _35_Search_Insert_Position {
    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3}, 2));
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int numArrayLength = nums.length;
        if (target > nums[numArrayLength - 1]) {
            return numArrayLength;
        }
        if (target < nums[0]) {
            return 0;
        }
        for (int i = 0; i < numArrayLength; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i <= numArrayLength - 2) {
                if (nums[i] < target && nums[i + 1] > target) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}