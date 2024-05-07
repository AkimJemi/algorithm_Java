package Programmers.Level1;

public class 콜라_문제 {
    public static void main(String[] args) {
        System.out.println(new Solution콜라_문제().solution(2, 1, 20));
        System.out.println(new Solution콜라_문제().solution(3, 1, 20));
    }
}

class Solution콜라_문제 {
    public int solution(int a, int b, int n) {
        int count = 0;
        int left = 0;
        while (n >= a) {
            left = (n / a) * b;
            count += left;
            n = (n % a) + left;
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */
class Solution콜라_문제1 {
    public int solution(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }
}

class Solution콜라_문제2 {
    public int solution(int a, int b, int n) {
        return recursive(a, b, n, 0);
    }

    public int recursive(int a, int b, int n, int result) {
        if (n < a) {
            return result;
        }
        int change = (n / a) * b;
        n = (n % a) + change;
        return recursive(a, b, n, result + change);
    }
}
