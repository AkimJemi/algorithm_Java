package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _228_Summary_Ranges {
    public static void main(String[] args) {
        System.out.println(new Solution228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Solution228().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(new Solution228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));

    }
}

class Solution228 {
    // my code
    public List<String> summaryRanges(int[] nums) {
        List<String> strList = new ArrayList<>();
        if (nums.length == 0) return strList;
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == nums[i])
                    strList.add(String.valueOf(nums[i]));
                else
                    strList.add(start + "->" + nums[i]);

                if (i != nums.length - 1)
                    start = nums[i + 1];
            }
        }
        return strList;
    }

    // test code
    public List<String> summaryRanges_test(int[] nums) {
        List<String> strList = new ArrayList<>();
        if (nums.length == 0) return strList;
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1])
                    strList.add(String.valueOf(start));
                else
                    strList.add(start + "->" + nums[i - 1]);

                if (i < nums.length)
                    start = nums[i];
            }
        }
        return strList;
    }

    // ChatGPT 改善
    public List<String> summaryRanges3(int[] nums) {
        List<String> strList = new ArrayList<>();
        if (nums.length == 0) {
            return strList;
        }

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            // Check if the current element is the last one or if it's not consecutive with the next one
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    strList.add(String.valueOf(start));
                } else {
                    strList.add(start + "->" + nums[i - 1]);
                }

                // Update start to the current element if it's not the last one
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return strList;
    }

    // others code
    public List<String> summaryRanges2(int[] nums) {
        StringBuilder s = new StringBuilder("");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                s.append(nums[i]).append("->");
                while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                    i++;
                }
                s.append(nums[i]);
                list.add(s.toString());
                s.setLength(0);
            } else {
                list.add(nums[i] + "");
            }
        }
        return list;
    }
}