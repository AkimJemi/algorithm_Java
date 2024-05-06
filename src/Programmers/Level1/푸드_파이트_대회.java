package Programmers.Level1;

public class 푸드_파이트_대회 {
    public static void main(String[] args) {
        System.out.println(new Solution푸드_파이트_대회().solution(new int[]{1, 3, 4, 6}));
        System.out.println(new Solution푸드_파이트_대회().solution(new int[]{1, 7, 1, 2}));
    }
}

class Solution푸드_파이트_대회 {
    public String solution(int[] food) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int fo : food) {
            if (fo < 2) {
                count++;
                continue;
            }
            stringBuilder.append(String.valueOf(count).repeat(fo / 2));
            count++;
        }
        String origin = stringBuilder.toString();
        return origin + "0" + stringBuilder.reverse();
    }
}