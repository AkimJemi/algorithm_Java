package Programmers.Level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 대충_만든_자판 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution대충_만든_자판().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
    }
}

class Solution대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        boolean check = true;
        for (int i = 0; i < targets.length; i++) {
            check = true;
            int count = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                String str = String.valueOf(targets[i].charAt(j));
                List<Integer> list = Arrays.stream(keymap).mapToInt(a -> a.indexOf(str)).filter(b -> b != -1).boxed().collect(Collectors.toList());
                if (list.isEmpty()) {
                    result[i] = -1;
                    check = false;
                    break;
                }
                count += list.stream().min((o1, o2) -> o1.compareTo(o2)).get() + 1;
            }
            if (check) {
                result[i] = count;
            }
        }
        return result;
    }
}