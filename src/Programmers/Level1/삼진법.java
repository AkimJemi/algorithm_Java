package Programmers.Level1;

import java.util.stream.IntStream;

class 삼진법 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
        System.out.println(new Solution삼진법().solution(45));
        System.out.println(new Solution삼진법().solution(125));
    }
}

class Solution삼진법 {
    private int formation(int num) {
        int init = 1;
        for (int i = 0; i < num; i++) init *= 3;
        return init;
    }

    public Integer solution(int n) {
        int count = 0;
        while (true) {
            if (formation(count) > n) {
                count--;
                break;
            }
            count++;
        }
        System.out.println(formation(count));
//        while ((target = n % initTarget) != 0) {
//            System.out.println(target);
//            initTarget *= 10;
//        }
        return null;
    }
}

/*
 *Someone else's code to study
 * */