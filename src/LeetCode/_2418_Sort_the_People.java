package LeetCode;

import java.util.Arrays;
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
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey())).map(a -> a.getValue()).toArray(String[]::new);
    }

    /*others code to study*/
    public String[] sortPeople1(String[] names, int[] heights) {
        qSort(names, heights, 0, heights.length - 1);
        return names;
    }

    public static int partition(int[] heights, String[] names, int low, int high) {
        int pivot = heights[high];  // Pivot is the last element
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is greater than or equal to the pivot
            if (heights[j] >= pivot) {
                i++;

                // Swap heights[i] and heights[j]
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;

                // Swap corresponding names
                String tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }

        // Swap heights[i + 1] and heights[high] (or pivot)
        int temp = heights[i + 1];
        heights[i + 1] = heights[high];
        heights[high] = temp;

        // Swap corresponding names
        String tempName = names[i + 1];
        names[i + 1] = names[high];
        names[high] = tempName;

        return i + 1;
    }

    public static void qSort(String[] names, int[] heights, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(heights, names, low, high);

            // Recursively sort elements before and after partition
            qSort(names, heights, low, pi - 1);
            qSort(names, heights, pi + 1, high);
        }
    }
}

