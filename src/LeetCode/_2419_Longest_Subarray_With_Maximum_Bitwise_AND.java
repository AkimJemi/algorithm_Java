package LeetCode;

public class _2419_Longest_Subarray_With_Maximum_Bitwise_AND {
    public static void main(String[] args) {
//        System.out.println(new Solution_2419_Longest_Subarray_With_Maximum_Bitwise_AND().longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
//        System.out.println(new Solution_2419_Longest_Subarray_With_Maximum_Bitwise_AND().longestSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution_2419_Longest_Subarray_With_Maximum_Bitwise_AND().longestSubarray(new int[]{1, 2, 3, 4, 4, 3, 5, 3, 4, 4, 4, 4}));

    }
}

class Solution_2419_Longest_Subarray_With_Maximum_Bitwise_AND {
    public int longestSubarray(int[] nums) {
        int maxNum = nums[0];
        int maxLength = 0;
        int doubleCheckMaxLength = 0;
        for (int num : nums) {
            if (num == maxNum) {
                maxLength++;
                continue;
            }
            if (num > maxNum) {
                maxNum = num;
                maxLength = 1;
                doubleCheckMaxLength = 1;
            }
            if (num < maxNum) {
                if (doubleCheckMaxLength < maxLength) {
                    doubleCheckMaxLength = maxLength;
                }
                maxLength = 0;
            }
        }
        return Math.max(doubleCheckMaxLength, maxLength);
    }
}