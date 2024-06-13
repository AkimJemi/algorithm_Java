package LeetCode;

public class _88_Merge_Sorted_Array {
    public static void main(String[] args) {
        new Solution88().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (nums1[i] < nums2[count]) {

            }
        }
    }
}