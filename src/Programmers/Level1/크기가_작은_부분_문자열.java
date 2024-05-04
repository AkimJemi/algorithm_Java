package Programmers.Level1;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class 크기가_작은_부분_문자열 {
    public static void main(String[] args) {
        System.out.println(new Solution크기가_작은_부분_문자열().solution("3141592", "271"));
        System.out.println(new Solution크기가_작은_부분_문자열().solution("500220839878", "7"));
        System.out.println(new Solution크기가_작은_부분_문자열().solution("10203", "15"));
        System.out.println(new Solution크기가_작은_부분_문자열().solution("1", "0"));
    }
}

class Solution크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        BigInteger pToInt = new BigInteger(p);
        int count = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            BigInteger target = new BigInteger(t.substring(i, i + p.length()));
            if (target.compareTo(pToInt) <= 0) {
                count++;
            }
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */
class Solution크기가_작은_부분_문자열1 {
    public int solution(String t, String p) {
        long targetNumber = Long.parseLong(p);
        int targetNumberLength = p.length();

        return (int) LongStream.range(0L, t.length() - targetNumberLength + 1L)
                .mapToObj(i -> t.substring((int) i, (int) i + targetNumberLength))
                .mapToLong(Long::parseLong)
                .filter(number -> number <= targetNumber)
                .count();
    }
}

class Solution크기가_작은_부분_문자열2 {
    public int solution(String t, String p) {
        int pLength = p.length();
        long pValue = Long.parseLong(p);
        int answer = 0;
        for (int i = 0; i <= t.length() - pLength; i++) {
            long tValue = Long.parseLong(t.substring(i, i + pLength));
            if (tValue <= pValue)
                answer++;
        }
        return answer;
    }
}

class Solution크기가_작은_부분_문자열3 {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length(); i++) {
            String num = t.substring(i, i + p.length());
            if (num.compareTo(p) < 1) {
                answer++;
            }
        }
        return answer;
    }
}