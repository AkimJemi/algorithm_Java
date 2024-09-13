package Programmers.Level2;

public class 다음_큰_숫자 {
    public static void main(String[] args) {
        System.out.println(new Solution다음_큰_숫자().nextBigNumber(78));
        System.out.println(new Solution다음_큰_숫자().nextBigNumber(15));
    }
}

class Solution다음_큰_숫자 {
    public int solution(int n) {
        int originOneCount = Integer.toBinaryString(n).replace("0", "").length();
        int nextValueOneCount = -1;
        while (originOneCount != nextValueOneCount) {
            nextValueOneCount = Integer.toBinaryString(++n).replace("0", "").length();
        }
        return n;
    }

    // others code
    public int nextBigNumber(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}