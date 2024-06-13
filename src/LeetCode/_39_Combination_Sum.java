package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _39_Combination_Sum {
    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{1, 2, 3}, 5));
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), target, candidates, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tmp, int target, int[] array, int start) {
//        if (tmp.stream().mapToInt(Integer::intValue).sum() == target) list.add(new ArrayList<>(tmp));
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < array.length; i++) {
            tmp.add(array[i]);
            backtrack(list, tmp, target, array, i + 1);
//            tmp.remove(tmp.size() - 1);
        }
    }
}