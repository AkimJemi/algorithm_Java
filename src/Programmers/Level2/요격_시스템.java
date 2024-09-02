package Programmers.Level2;

import java.util.*;
import java.util.stream.Collectors;

public class 요격_시스템 {
    public static void main(String[] args) {
        System.out.println(new Solution요격_시스템().solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}

class Solution요격_시스템 {
    public int solution(int[][] targets) {
        Map<String, Integer> minimumInterception = new HashMap<>();
        List<String> targetMap = new ArrayList<>();
        for (int i = 0; i < targets.length; i++) {
            for (int j = targets[i][0]; j < targets[i][1]; j++) {
                String tmp = j + "-" + (j + 1);
                minimumInterception.put(tmp, minimumInterception.getOrDefault(tmp, 0) + 1);
            }
            String tmp = targets[i][0] + "-" + (targets[i][0] + 1) + "";
            if (!targetMap.contains(tmp)) {
                targetMap.add(tmp);
            }
            tmp = targets[i][1] + "-" + (targets[i][1] + 1);
            if (!targetMap.contains(tmp)) {
                targetMap.add(tmp);
            }
        }
        System.out.println(minimumInterception.entrySet().stream().filter(a -> targetMap.contains(a.getKey())).collect(Collectors.toList()));
        return minimumInterception.entrySet().stream().filter(a -> targetMap.contains(a.getKey())).max((a, b) -> a.getValue().compareTo(b.getValue())).get().getValue();
    }
}