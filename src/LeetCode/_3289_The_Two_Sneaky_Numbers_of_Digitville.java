package LeetCode;

import java.util.Arrays;

public class _3289_The_Two_Sneaky_Numbers_of_Digitville {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_3289_The_Two_Sneaky_Numbers_of_Digitville().getSneakyNumbers2(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2})));
    }
}

class Solution_3289_The_Two_Sneaky_Numbers_of_Digitville {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        Integer first = null;
        Integer second = null;
        for (int i = 0; i < nums.length - 2; i++) {
            int fir = nums[i];
            int sec = nums[i + 1];
            int thr = nums[i + 2];
            if (fir == sec && sec != thr) {
                if (first == null) {
                    first = fir;
                } else if (second == null) {
                    second = fir;
                    break;
                }
                i++;
            }
        }
        if (second == null && nums.length > 3 && nums[nums.length - 3] != nums[nums.length - 2] && nums[nums.length - 2] == nums[nums.length - 1]) {
            second = nums[nums.length - 2];
        }
        return new int[]{first, second};
    }

    // others code
    public int[] getSneakyNumbers2(int[] nums) {
        int x = nums[nums.length - 1];
        while (nums[x] != x) {
            int temp = nums[x];
            nums[x] = x;
            x = temp;
        }
        int a = x;
        x = nums[nums.length - 2];
        while (nums[x] != x) {
            int temp = nums[x];
            nums[x] = x;
            x = temp;
        }
        int b = x;
        return new int[]{a, b};
    }
}