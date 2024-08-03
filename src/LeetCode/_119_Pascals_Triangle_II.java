package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _119_Pascals_Triangle_II {
    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(3));
    }
}

class Solution119 {
    public List<Integer> getRow(int row) {
        List<Integer> list = new ArrayList<>();
        long ans = 1;
        list.add(1);
        for (int col = 1; col < row + 1; col++) {
            list.add((int) (ans = (ans * (row + 1 - col)) / col));
        }
        return list;
    }
}