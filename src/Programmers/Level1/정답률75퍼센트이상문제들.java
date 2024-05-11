package Programmers.Level1;

import java.util.Arrays;

public class 정답률75퍼센트이상문제들 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
        System.out.println(new Solution문자열_내_p와_y의_개수().solution("pPoooyY"));
    }
}

class Solution문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        int pCount = 0;
        int sCount = 0;
        for (Character cha : s.toCharArray()) {
            pCount = cha == 'p' || cha == 'P' ? pCount + 1 : pCount;
            sCount = cha == 'y' || cha == 'Y' ? sCount + 1 : sCount;
        }
        return pCount == sCount;
    }

    /*
     *Someone else's code to study
     * */
    boolean solution2(String s) {
        s = s.toUpperCase();
        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
    boolean solution3(String s) {
        return s.replaceAll("[^yY]", "").length() - s.replaceAll("[^pP]", "").length() == 0 ? true : false;
    }
}

