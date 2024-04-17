package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 더_멥게 {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}

class Solution1 {
//    public int solution(int[] scoville, int K) {
//        int plus = 0;
//        for (int i = 0; i < scoville.length; i++) {
//            Arrays.sort(scoville);
//            if (scoville[i] < K) {
//                if ((i == scoville.length - 1)) {
//                    return -1;
//                }
//                plus = scoville[i] + scoville[i + 1] * 2;
//            } else {
//                return i;
//            }
//            if (plus <= scoville[i + 1]) {
//                scoville[i + 1] = scoville[i + 1] + plus * 2;
//            } else {
//                scoville[i] = K + 1;
//            }
//        }
//        return -1;
//    }

    public int solution(int[] scoville, int K) {
        List<Integer> list = Arrays.stream(scoville).boxed().sorted().collect(Collectors.toList());
        int count = 0;
        while (list.stream().filter(a -> a < K).findAny().isPresent()) {
            if (list.size() == 1) {
                return -1;
            }
            list.set(0, list.get(0) + list.get(1) * 2);
            list.remove(1);
            count++;
            Collections.sort(list);
        }
        return count;
    }
}