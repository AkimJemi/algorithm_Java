package Programmers.Level2;

public class 숫자의_표현 {
    public static void main(String[] args) {
        System.out.println(new Solution숫자의_표현().solution(15));

    }
}

class Solution숫자의_표현 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            for (int j = i; j <= n / 2 + 1; j++) {
                sum += j;
                if (sum == n) answer++;
                if (sum > n) {
                    break;
                }
            }
        }
        return answer + 1;
    }
}