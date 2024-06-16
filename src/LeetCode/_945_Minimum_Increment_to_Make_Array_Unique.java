package LeetCode;

public class _945_Minimum_Increment_to_Make_Array_Unique {
    public static void main(String[] args) {
        System.out.println(new Solution945().minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(new Solution945().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));

    }
}

class Solution945 {
    public int minIncrementForUnique(int[] nums) {
        int[] box = new int[100000];
        for (int num : nums) box[num]++;

        for (int i = 0; i < nums.length; i++) {
            boolean check = false;
            while (box[nums[i]] != 0 || check) {
                int j = i;
                while (true) {
                    if (j == 100000 - 1) j = 0;
                    if (box[j] != 0) {
                        j++;
                        continue;
                    }


                }


            }

        }

        return Byte.MAX_VALUE;
    }
}