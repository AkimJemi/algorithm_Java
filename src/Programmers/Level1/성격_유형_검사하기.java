package Programmers.Level1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        int[] intArray = new int[]{5, 3, 2, 7, 5};
        String[] strArray = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        System.out.println(new Solution성격_유형_검사하기().solution(strArray, intArray));
        intArray = new int[]{7, 1, 3};
        strArray = new String[]{"TR", "RT", "TR"};
        System.out.println(new Solution성격_유형_검사하기().solution(strArray, intArray));
    }
}

class Solution성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String[] aSurveryArray = survey[i].split("");
            int choice = choices[i];
            String target = null;
            int point = 0;
            if (choice < 4) {
                point = 4 - choice;
                target = aSurveryArray[0];
            } else {
                point = choice - 4;
                target = aSurveryArray[1];
            }
            map.put(target, map.getOrDefault(target, 0) + point);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getHigherType(map, "R", "T"));
        stringBuilder.append(getHigherType(map, "C", "F"));
        stringBuilder.append(getHigherType(map, "J", "M"));
        stringBuilder.append(getHigherType(map, "A", "N"));
        return stringBuilder.toString();
    }

    String getHigherType(Map<String, Integer> map, String typeFirst, String typeSecond) {
        return map.getOrDefault(typeFirst, 0) >= map.getOrDefault(typeSecond, 0) ? typeFirst : typeSecond;
    }

}

/*
 *Someone else's code to study
 * */