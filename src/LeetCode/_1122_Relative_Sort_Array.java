package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class _1122_Relative_Sort_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Long> collect = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            if (collect.containsKey(num)) {
                for (int j = 0; j < collect.get(num); j++) {
                    arr1[index++] = num;
                }
                collect.remove(num);
            }
        }
        for (Map.Entry<Integer, Long> entry : collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList())) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr1[index++] = entry.getKey();
            }
        }
        return arr1;
    }
}