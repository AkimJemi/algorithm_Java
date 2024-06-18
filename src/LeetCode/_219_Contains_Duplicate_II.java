package LeetCode;

public class _219_Contains_Duplicate_II {
    public static void main(String[] args) {
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 5, 6, 7, 8}, 3));
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{99, 99}, 2));
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}, 3));
//        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 5, 0}, 5));
    }
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= k) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i + 1; j < i + k + 1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            for (int j = i - 1; j > i - k && j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}