package Programmers.Level1;

import java.util.Arrays;

public class 삼총사 {
    public static void main(String[] args) {
        System.out.println(new Solution삼총사().solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(new Solution삼총사().solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(new Solution삼총사().solution(new int[]{-1, 1, -1, 1}));
    }
}

class Solution삼총사 {
    public int solution(int[] number) {
        Arrays.sort(number);
        int count = 0;
        for (int i = 0; i < number.length - 2; i++) {
            int sumI = number[i];
            if (sumI > 0) break;
            for (int j = i + 1; j < number.length - 1; j++) {
                int sumIJ = sumI + number[j];
                if (sumIJ > 0) break;
                for (int n = j + 1; n < number.length; n++) {
                    int sumIJN = sumIJ + number[n];
                    if (sumIJN == 0) count++;
                    else if (sumIJN > 0) break;
                }
            }
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */