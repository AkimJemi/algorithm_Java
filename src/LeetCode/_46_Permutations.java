package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3 }));
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int start = 0;
        permuteMethod(list, tmp, nums, 0);
        return list;
    }

    private void permuteMethod(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
        if (tmp.size() == nums.length) list.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            permuteMethod(list, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}