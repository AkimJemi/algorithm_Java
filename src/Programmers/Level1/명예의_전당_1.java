package Programmers.Level1;

import java.util.*;
import java.util.stream.IntStream;

public class 명예의_전당_1 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
        System.out.println(Arrays.toString(new Solution명예의_전당_1().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }
}

class Solution명예의_전당_1 {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            if (list.size() == k + 1) {
                Collections.sort(list);
                list.remove(0);
            }
            result[i] = Collections.min(list);
        }
        return result;
    }
}
/*
 *Someone else's code to study
 * */


class Solution명예의_전당_1_1 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++) {
            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            answer[i] = priorityQueue.peek();
        }
        return answer;
    }
}
class Solution명예의_전당_1_2 {
    public int[] solution(int k, int[] score) {
        Integer[] scores = new Integer[score.length];

        return IntStream.range(0, score.length)
                .peek(i -> scores[i] = score[i])
                .map(i -> {
                    Arrays.sort(scores, 0, i + 1, Collections.reverseOrder(Integer::compare));
                    return i < k ? scores[i] : scores[k - 1];
                })
                .toArray();
    }
}
