package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class _169_Majority_Element {
    public static void main(String[] args) {
        System.out.println(new Solution169().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution169().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}