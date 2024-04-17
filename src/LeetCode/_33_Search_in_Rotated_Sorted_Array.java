package LeetCode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList()).indexOf(target);
    }
}