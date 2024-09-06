package Programmers.Level2;

import java.util.Arrays;

public class 이진_변환_반복하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution이진_변환_반복하기().solution("110010101001")));
        System.out.println(Arrays.toString(new Solution이진_변환_반복하기().solution("01110")));
        System.out.println(Arrays.toString(new Solution이진_변환_반복하기().solution("1111111")));

    }
}

class Solution이진_변환_반복하기 {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        while (true) {
            if (s.equals("1")) break;
            int originLength = s.length();
            s = s.replace("0", "");
            zero += originLength - s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }
        return new int[]{count, zero};
    }
}