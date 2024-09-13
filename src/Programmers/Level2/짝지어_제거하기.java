package Programmers.Level2;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        System.out.println(new Solution짝지어_제거하기().solution("baabaa"));
        System.out.println(new Solution짝지어_제거하기().solution("cdcd"));
    }
}

class Solution짝지어_제거하기 {
    public int solution(String s) {
        StringBuilder sb = null;
        int prevLength = 0;
        do {
            prevLength = s.length();
            char[] charArray = s.toCharArray();
            sb = new StringBuilder();
            for (int i = 0; i < charArray.length - 1; ) {
                if (i == charArray.length - 2 && charArray[i] != charArray[i + 1]) {
                    sb.append(charArray[i]);
                    sb.append(charArray[i + 1]);
                    break;
                }
                if (charArray[i] != charArray[i + 1]) {
                    sb.append(charArray[i]);
                    i++;
                } else {
                    i += 2;
                }
            }
            s = sb.toString();
        } while (prevLength != s.length());
        return sb.length() == 0 ? 1 : 0;
    }

    public int solution2(String s) {
        StringBuilder sb = null;
        int prevLength = 0;
        do {
            prevLength = s.length();
            char[] charArray = s.toCharArray();
            sb = new StringBuilder();
            for (int i = 0; i < charArray.length - 1; ) {
                if (i == charArray.length - 2 && charArray[i] != charArray[i + 1]) {
                    sb.append(charArray[i]);
                    sb.append(charArray[i + 1]);
                    break;
                }
                if (charArray[i] != charArray[i + 1]) {
                    sb.append(charArray[i]);
                    i++;
                } else {
                    i += 2;
                }
            }
            s = sb.toString();
        } while (prevLength != s.length());
        return sb.length() == 0 ? 1 : 0;
    }
}