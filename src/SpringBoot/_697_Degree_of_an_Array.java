package SpringBoot;

import java.util.Arrays;

public class _697_Degree_of_an_Array {
    public static void main(String[] args) {
        System.out.println(new Solution697().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new Solution697().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2, 1}));
    }
}

class Solution697 {
    public int findShortestSubArray(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }
        int max = 0;
        int maxNum = 0;
        int secMax = -1;
        int secMaxNum = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxNum = i;
                continue;
            }
            if (array[i] == max) {
                secMax = array[i];
                secMaxNum = i;
            }
        }
        int sumLength = nums.length;
        if (max == secMax) {
            System.out.println("test");

        } else {
            for (int i = 0; i < array.length; i++) {
                if (nums[i] == maxNum) {
                    break;
                }
                sumLength -= 1;
            }
            for (int i = array.length - 1; i > 0; i--) {
                if (nums[i] == maxNum) {
                    break;
                }
                sumLength += 1;
            }
        }
        return sumLength;
    }
}