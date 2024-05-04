package Programmers.Level1;

import java.util.HashMap;
import java.util.Map;

public class 문자열_나누기 {

    public static void main(String[] args) {
        System.out.println(new Solution문자열_나누기().solution("banana") == 3);
        System.out.println(new Solution문자열_나누기().solution("abracadabra") == 6);
        System.out.println(new Solution문자열_나누기().solution("aaabbaccccabba") == 3);
        System.out.println(new Solution문자열_나누기().solution("a") == 1);
        System.out.println(new Solution문자열_나누기().solution("ab") == 1);
        System.out.println(new Solution문자열_나누기().solution("aba") == 2);
        System.out.println(new Solution문자열_나누기().solution("aaba") == 1);
        System.out.println(new Solution문자열_나누기().solution("aababba") == 2);
        System.out.println(new Solution문자열_나누기().solution("aabacbcd") == 3);
        System.out.println(new Solution문자열_나누기().solution("aaaaaaaabbba") == 1);
        System.out.println(new Solution문자열_나누기().solution("abaaaaaabbba") == 2);
        System.out.println(new Solution문자열_나누기().solution("abaabab") == 2);
        System.out.println(new Solution문자열_나누기().solution("aaabb") == 1);
        System.out.println(new Solution문자열_나누기().solution("aaabbc") == 1);
        System.out.println(new Solution문자열_나누기().solution("ccdd ") == 2);
        System.out.println(new Solution문자열_나누기().solution("aaabbcccdd ") == 3);
    }
}

class Solution문자열_나누기 {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String target = String.valueOf(s.charAt(i));
            if (map.isEmpty()) {
                map.put(target, map.getOrDefault(target, 0) + 1);
                if (i == s.length() - 1) {
                    count++;
                }
                continue;
            }
            map.put(target, map.getOrDefault(target, 0) + 1);
            Integer targetCount = map.getOrDefault(target, 0);
            boolean targetResult = false;
            for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
                if (!mapEntry.getKey().equals(target) && mapEntry.getValue().equals(targetCount)) {
                    map = new HashMap<>();
                    count++;
                    targetResult = true;
                    break;
                }
            }
            if (!targetResult && i == s.length() - 1) {
                count++;
            }
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */
