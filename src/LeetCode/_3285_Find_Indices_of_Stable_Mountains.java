package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _3285_Find_Indices_of_Stable_Mountains {
    public static void main(String[] args) {

    }
}

class Solution_3285_Find_Indices_of_Stable_Mountains {
    public List<Integer> stableMountais(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                list.add(i);
            }
        }
        return list;
    }
}