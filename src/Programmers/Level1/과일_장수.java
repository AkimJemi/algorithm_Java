package Programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

public class 과일_장수 {
    public static void main(String[] args) {
        System.out.println(new Solution과일_장수().solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(new Solution과일_장수().solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{1, 1, 1, 1, 1}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{1}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{0}));
        System.out.println(new Solution과일_장수().solution(4, 5, new int[]{}));
    }
}

class Solution과일_장수 {

    public int solution(int k, int m, int[] score) {
        Integer[] scoreTrans = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreTrans, Collections.reverseOrder());
        int result = 0;
        for (int i = m - 1; i < scoreTrans.length; i = i + m) {
            result += scoreTrans[i] * m;
        }
        return result;
    }
    public int solution2(int k, int m, int[] score) {
        int result = 0;
        if (score.length > 100000) {
            Integer[] scoreTrans = Arrays.stream(score).boxed().toArray(Integer[]::new);
            Arrays.sort(scoreTrans, Collections.reverseOrder());
            for (int i = m - 1; i < scoreTrans.length; i = i + m) {
                result += scoreTrans[i] * m;
            }
        } else {
            for (int i = 1; i < score.length; i++) {
                int j = i;
                int y = score[i];
                while ((j > 0) && (score[j - 1] < y)) {
                    score[j] = score[j-- - 1];
                }
                score[j] = y;
            }
            for (int i = m - 1; i < score.length; i = i + m) {
                result += score[i] * m;
            }
        }
        return result;
    }
}

/*
 *Someone else's code to study
 * */