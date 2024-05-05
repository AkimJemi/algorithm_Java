package Programmers.Level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 기사단원의_무기 {
    public static void main(String[] args) {
        System.out.println(new Solution기사단원의_무기().solution(5, 3, 2));
        System.out.println(new Solution기사단원의_무기().solution(10, 3, 2));
    }
}

class Solution기사단원의_무기 {
    public int solution(int number, int limit, int power) {
        return IntStream.rangeClosed(1, number).map(a -> {
                    int cnt = 0;
                    for (int i = 1; i * i <= a; i++) {
                        if (i * i == a) cnt++;
                        else if (a % i == 0) cnt += 2;
                    }
                    return cnt > limit ? power : cnt;
                }
        ).sum();
    }
    public int solution2(int number, int limit, int power) {
        int[] result = new int[number];
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) cnt++;
                else if (i % j == 0) cnt += 2;
            }
            result[i - 1] = cnt > limit ? power : cnt;
        }
        return Arrays.stream(result).sum();
    }
}

/*
 *Someone else's code to study
 * */
class Solution기사단원의_무기1 {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}