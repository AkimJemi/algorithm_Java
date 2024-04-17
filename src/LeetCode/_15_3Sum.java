package LeetCode;

import java.util.*;

public class _15_3Sum {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{1,-1,-1,0}));
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
            for (int j = i + 1; j < nums.length; j++) {
                int jVal = nums[j];
                if (jP == null) jP = jVal;
                else if (jVal == jP) continue;
                jP = jVal;
                for (int k = j + 1; k < nums.length; k++) {
                    int kVal = nums[k];
                    if (iVal + jVal + kVal == 0) {
                        setList.add(Arrays.asList(iVal, jVal, kVal));
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(setList);
    }
}
