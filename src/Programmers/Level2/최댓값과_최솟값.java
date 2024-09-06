package Programmers.Level2;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        System.out.println(new Solution최댓값과_최솟값().solution("1 2 3 4"));
        System.out.println(new Solution최댓값과_최솟값().solution("-1 -2 -3 -4"));
        System.out.println(new Solution최댓값과_최솟값().solution("-1 -1"));
    }
}

class Solution최댓값과_최솟값 {
    public String solution(String s) {
        String[] array = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : array) {
            Integer val = Integer.valueOf(str);
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }
        return min + " " + max;
    }
}