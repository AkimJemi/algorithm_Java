package Programmers.Level1;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * */
public class 카드_뭉치 {
    public static void main(String[] args) {
        System.out.println(
                new Solution카드_뭉치().solution(
                        new String[]{"i", "drink", "water"},
                        new String[]{"want", "to"},
                        new String[]{"i", "want", "to", "drink", "water"}).equals("Yes"));
        System.out.println(
                new Solution카드_뭉치().solution(
                        new String[]{"i", "water", "drink"},
                        new String[]{"want", "to"},
                        new String[]{"i", "want", "to", "drink", "water"}).equals("No"));
    }
}

class Solution카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Index = 0;
        int cards2Index = 0;
        for (int i = 0; i < goal.length; i++) {
            if (cards1Index < cards1.length) {
                if (cards1[cards1Index].equals(goal[i])) {
                    cards1Index++;
                    continue;
                }
            }
            if (cards2Index < cards2.length) {
                if (cards2[cards2Index].equals(goal[i])) {
                    cards2Index++;
                    continue;
                }
            }
            return "No";
        }
        return "Yes";
    }
}