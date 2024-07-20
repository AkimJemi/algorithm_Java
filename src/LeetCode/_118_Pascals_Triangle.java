package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _118_Pascals_Triangle {
    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5));
        System.out.println(new Solution118().generate(10));
        System.out.println(new Solution118().generate(1));
        System.out.println(new Solution118().generate(2));
    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sum = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        sum.add(list);
        if (numRows == 1) return sum;

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        sum.add(list);
        for (int i = 2; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(sum.get(i - 1).get(j - 1) + sum.get(i - 1).get(j));
            }
            list.add(1);
            sum.add(list);
        }
        return sum;
    }
}