package Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 실패율 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution실패율().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
//        System.out.println(Arrays.toString(new Solution실패율().solution(4, new int[]{4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(new Solution실패율().solution(4, new int[]{4, 3, 1, 5})));
        System.out.println(Arrays.toString(new Solution실패율().solution(4, new int[]{4, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5})));
    }
}

class Solution실패율 {
    public int[] solution(int N, int[] stages) {
        double length = stages.length;
        Map<Integer, Long> map = Arrays.stream(stages).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        Map<Integer, Double> resultMap = new HashMap<>();

        System.out.println(map);
        for (int i = 1; i <= N; i++) {
            double mapValue = Double.valueOf(map.getOrDefault(i, Long.valueOf(0)));
            resultMap.put(i, mapValue == 0 || length == 0 ? 0 : mapValue / length);
            length -= mapValue;
        }
        System.out.println(resultMap);
        return resultMap.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue() <= o2.getValue() ? 1 : -1)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}