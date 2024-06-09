package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class _15_3Sum {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{0, 0, 0}));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> setList = new HashSet<>();
        Integer iP = null;
        Integer jP = null;
        for (int i = 0; i < nums.length; i++) {
            int iVal = nums[i];
            if (iP == null) iP = iVal;
            else if (iVal == iP) continue;
            iP = iVal;
            if (iVal > 0) break;
            for (int j = i + 1; j < nums.length; j++) {
                int jVal = nums[j];
                if (jP == null) jP = jVal;
                else if (jVal == jP) continue;
                jP = jVal;
                if (iVal + jVal > 0) break;
                for (int k = j + 1; k < nums.length; k++) {
                    int kVal = nums[k];
                    if (iVal + jVal + kVal > 0) break;
                    if (iVal + jVal + kVal == 0) {
                        setList.add(Arrays.asList(iVal, jVal, kVal));
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(setList);
    }
    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) break;
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (nums[i] + nums[j] > 0) break;
//                for (int n = j + 1; n < nums.length; n++) {
//                    if (nums[i] + nums[j] + nums[n] > 0) break;
//                    if (nums[i] + nums[j] + nums[n] == 0) {
//                        int min = Math.min(Math.min(nums[i], nums[j]), nums[n]);
//                        int max = Math.max(Math.max(nums[i], nums[j]), nums[n]);
//                        int mid = nums[i] + nums[j] + nums[n] - max - min;
//                        List<Integer> tmp = List.of(min, mid, max);
//                        if (!list.contains(tmp)) list.add(tmp);
//                    }
//                }
//            }
//        }
//        return list;
//    }
}