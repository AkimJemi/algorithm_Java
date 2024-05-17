package Programmers.Level3;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution이중우선순위큐().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(new Solution이중우선순위큐().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}

class Solution이중우선순위큐 {
    public int[] solution(String[] operations) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            int num = Integer.valueOf(operation[1]);
            String oper = operation[0];
            if (oper.equals("D")) {
                if (!numList.isEmpty()) {
                    if (num == 1) {
                        numList.remove(numList.stream().max(Comparator.naturalOrder()).get());
                    } else {
                        numList.remove(numList.stream().min(Comparator.naturalOrder()).get());
                    }
                }
            } else numList.add(num);
        }
        return numList.isEmpty() ? new int[]{0, 0} : new int[]{numList.stream().max(Comparator.naturalOrder()).get(), numList.stream().min(Comparator.naturalOrder()).get()};
    }

}