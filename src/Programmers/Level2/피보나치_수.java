package Programmers.Level2;

public class 피보나치_수 {
    public static void main(String[] args) {
        System.out.println("n 1 : = " + new Solution피보나치_수().solution(100000));

    }
}

class Solution피보나치_수 {
    public int solution(int n) {
        int prev = 1;
        int prevv = 0;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prevv + prev;
            prevv = prev % 1234567;
            prev = cur % 1234567;
        }
        return cur % 1234567;
    }
}