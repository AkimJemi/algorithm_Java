package LeetCode;

import java.util.Arrays;

public class _88_Merge_Sorted_Array {
    public static void main(String[] args) {
        new Solution88().merge2(new int[]{-1, 1, 0, 0, 0, 0, 0, 0}, 2, new int[]{-1, 0, 1, 1, 2, 3}, 6);
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n, j = 0; i > 0; j++) {
            if (nums1[j] == 0) {
                nums1[j] = nums2[nums2.length - i];
                i--;
            }
        }
        int start = 0;
        int end = nums1.length - 1;
        while (true) {
            if (end == 0) break;
            if (start == end) {
                end--;
                start = 0;
            }
            if (nums1[start] > nums1[start + 1]) {
                int mid = nums1[start];
                nums1[start] = nums1[start + 1];
                nums1[start + 1] = mid;
            }
            start++;
        }
    }


    // others code
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = m + n - 1;
        int k = n - 1;
        while (j >= 0 && k >= 0) {
            if (i < 0) {
                while (j >= 0 && k >= 0) {
                    nums1[j--] = nums2[k--];
                }
            } else {
                if (nums1[i] > nums2[k]) {
                    nums1[j--] = nums1[i--];
                }
                else{
                    nums1[j--] = nums2[k--];
                }
            }
        }
    }
}