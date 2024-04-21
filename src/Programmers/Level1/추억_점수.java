package Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 추억_점수 {
    public static void main(String[] args) {
        String[] name = new String[]{"may", "kein", "kain", "radi"};
        int[] yearning = new int[]{5, 10, 1, 3};
        String[][] photo = new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(new Solution_추억_점수().solution_다른사람풀이(name, yearning, photo)));
    }
}

class Solution_추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] result = new int[photo.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (String phoName : photo[i]) {
                if (map.containsKey(phoName)) {
                    sum += map.get(phoName);
                }
            }
            result[i] = sum;
        }
        return result;
    }
    public int[] solution_다른사람풀이(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length).mapToObj(operand -> Map.entry(name[operand], yearning[operand])).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Arrays.stream(photo).mapToInt(strings -> Arrays.stream(strings).mapToInt(value -> map.getOrDefault(value, 0)).sum()).toArray();
    }
}