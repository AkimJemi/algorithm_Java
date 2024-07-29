package LeetCode;

public class _283_Move_Zeroes {
    public static void main(String[] args) {
        new Solution283().moveZeroes(new int[]{1, 0, 1});

    }
}

class Solution283 {
    // mycode
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int numIndex = 0;
        while (true) {
            if (zeroIndex == nums.length - 1 || numIndex == nums.length) break;
            if (nums[zeroIndex] != 0) {
                zeroIndex++;
                continue;
            }
            if (nums[numIndex] == 0 || numIndex < zeroIndex) {
                numIndex++;
                continue;
            }
            int mid = nums[numIndex];
            nums[numIndex] = nums[zeroIndex];
            nums[zeroIndex] = mid;
        }
    }

    // others code
    public void moveZeroes2(int[] nums) {
        if (nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++)
            nums[j++] = 0;
    }
}