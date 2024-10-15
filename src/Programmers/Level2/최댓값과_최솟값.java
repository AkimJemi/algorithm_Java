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
        int max = Integer.parseInt(array[0]);
        int min = Integer.parseInt(array[0]);
        for (String str : array) {
            int val = Integer.parseInt(str);
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