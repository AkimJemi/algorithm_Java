package LeetCode;

import java.util.Arrays;

public class _75_Sort_Colors {

    public static void main(String[] args) {
        new Solution75().sortColors1(new int[]{2, 0, 2, 1, 1, 0});
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int mid = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int index = 0;
            while (index != nums.length - 1 - i) {
                if (nums[index] > nums[index + 1]) {
                    mid = nums[index];
                    nums[index] = nums[index + 1];
                    nums[index + 1] = mid;
                }
                index++;
            }
        }
    }

    /* other's solution to study */
    public void sortColors1(int[] nums) {
        int firstIndex = 0, lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] == 0 && i != firstIndex) {
                int mid = nums[i];
                nums[i] = nums[firstIndex];
                nums[firstIndex] = mid;
                firstIndex++;
            } else if (lastIndex > i && nums[i] == 2) {
                int mid = nums[i];
                nums[i] = nums[lastIndex];
                nums[lastIndex] = mid;
                lastIndex--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}