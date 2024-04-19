package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _41_First_Missing_Positive {

    public static void main(String[] args) {
        System.out.println(new Solution41_study().firstMissingPositive(new int[]{1,2,3,5,7}));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).filter(a -> a > 0).sorted().distinct().boxed().collect(Collectors.toList());
        if (list.size() == 0) {
            return 1;
        }
        if (list.get(0) != 1) {
            return 1;
        }
        int preNum = 0;
        for (Integer num : list) {
            if (++preNum != num) {
                return preNum;
            }
        }
        return list.get(list.size() - 1) + 1;
    }
}
class Solution41_study {
    // Function to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each positive integer i at index i-1 if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }
}