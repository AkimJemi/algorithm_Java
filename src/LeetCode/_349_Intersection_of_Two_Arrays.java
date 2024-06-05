package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class _349_Intersection_of_Two_Arrays {
    class Solution349 {
        public int[] intersection(int[] nums1, int[] nums2) {
            return Arrays.stream(nums1).boxed().collect(Collectors.toList()).stream()
                    .distinct()
                    .filter(Arrays.stream(nums2)
                            .boxed()
                            .collect(Collectors.toList())::contains)
                    .collect(Collectors.toSet())
                    .stream()
                    .mapToInt(Integer::intValue).toArray();
        }
    }
}