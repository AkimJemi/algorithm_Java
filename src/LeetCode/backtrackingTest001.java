package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class backtrackingTest001 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] array = {2, 3, 4, 7, 9};
        backtracking(list, tmp, array, 0);
        System.out.println(list.stream().map(a -> a.stream().mapToInt(Integer::intValue).sum()).collect(Collectors.toList()));
    }

    private static void backtracking(List<List<Integer>> list, List<Integer> tmp, int[] array, int start) {
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < array.length; i++) {
            tmp.add(array[i]);
            backtracking(list, tmp, array, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
