package Programmers.Level1;

import java.util.Arrays;

public class 가장_가까운_같은_글자 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution가장_가까운_같은_글자().solution("banana")));
        System.out.println(Arrays.toString(new Solution가장_가까운_같은_글자().solution("foobar")));

    }
}

class Solution가장_가까운_같은_글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String compare = s.substring(0, i);
            int closestLetterIndex = compare.lastIndexOf(s.charAt(i));
            answer[i] = closestLetterIndex == -1 ? -1 : i - closestLetterIndex;
        }
        return answer;
    }
}