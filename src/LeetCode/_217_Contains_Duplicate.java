package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {
    public static void main(String[] args) {
//        new Solution217().containsDuplicate2(new int[]{5, 4, 3, 2, 1, 2, 3, 4, 5});
        new Solution217().containsDuplicate2(new int[]{1, 2, 3, -3, 6, 4, 5, 10, 15, 4});
    }
}

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().boxed().mapToInt(Integer::intValue).toArray().length != nums.length;
    }

    /* others code */
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        System.gc();
        Set<Integer> unique = new HashSet<Integer>();
        for (int num : nums) {
            unique.add(num);
        }
        return unique.size() != nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {
        int i = 1;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else if (nums[i] < nums[i - 1]) {
                for (int j = i - 2; j >= 0; j--) {
                    if (nums[i] == nums[j]) return true;
                }
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
            i++;
        }
        return false;
    }
    public boolean containsDuplicate3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}