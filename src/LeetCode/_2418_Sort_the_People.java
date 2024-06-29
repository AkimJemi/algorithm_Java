package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _2418_Sort_the_People {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2418().sortPeople(
                new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(new Solution2418().sortPeople(
                new String[]{"Alice", "Bob", "Bobb"}, new int[]{155, 185, 150})));

    }
}

class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(i, heights[i]);
        }
        Integer[] resultIndex = map.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).map(a -> a.getKey()).toArray(Integer[]::new);
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = names[resultIndex[i]];
        }
        return result;
    }
}