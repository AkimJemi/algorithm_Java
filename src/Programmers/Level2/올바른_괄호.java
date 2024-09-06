package Programmers.Level2;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(new Solution올바른_괄호().solution("()()"));
        System.out.println(new Solution올바른_괄호().solution("(())()"));
        System.out.println(new Solution올바른_괄호().solution(")()("));
        System.out.println(new Solution올바른_괄호().solution("(()("));
    }
}

class Solution올바른_괄호 {
    boolean solution(String s) {
        int openCount = 0;
        int closeCount = 0;
        char[] array = s.toCharArray();
        for (char cha : array) {
            if (cha == ')') {
                closeCount++;
                if (closeCount > openCount) return false;
                openCount--;
                closeCount--;
            }
            if (cha == '(') {
                openCount++;
                if (closeCount > openCount) return false;
            }
            if (openCount < 0) return false;
        }
        return openCount == 0 && closeCount == 0;
    }

    // others code
    boolean solution2(String s) {
        boolean answer = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }
        if (count == 0) {
            answer = true;
        }
        return answer;
    }
}