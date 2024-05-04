package Programmers.Level1;

import java.math.BigInteger;

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