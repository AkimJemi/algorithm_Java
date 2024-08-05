package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class _290_Word_Pattern {
    public static void main(String[] args) {
//        System.out.println(new Solution290().wordPattern("abba", "dog cat cat dog"));
//        System.out.println(new Solution290().wordPattern("abba", "dog cat cat fish"));
//        System.out.println(new Solution290().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution290().wordPattern("abba", "dog dog dog dog"));

    }
}

class Solution290 {
    // mycode
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        char[] chaArray = pattern.toCharArray();
        if (strArray.length != chaArray.length) return false;
        Map<Character, String> map = new HashMap<>();
        int index = 0;
        for (Character cha : chaArray) {
            if (map.containsKey(cha)) {
                if (!map.get(cha).equals(strArray[index])) return false;
            } else {
                if (map.containsValue(strArray[index])) return false;
            }
            map.put(cha, strArray[index++]);
        }
        return true;
    }

    // others code
    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> fMap = new HashMap<>();
        Map<String, Character> rMap = new HashMap<>();
        String[] str = s.split(" ");
        if (pattern.length() != str.length) return false;

        for (int i = 0; i < str.length; ++i) {
            char currChar = pattern.charAt(i);
            if (!fMap.containsKey(currChar) && !rMap.containsKey(str[i])) {
                fMap.put(currChar, str[i]);
                rMap.put(str[i], currChar);
            } else {
                if (!fMap.containsKey(currChar) && rMap.containsKey(str[i])) return false;
                if (fMap.containsKey(currChar)) {
                    if (!str[i].equals(fMap.get(currChar))) return false;
                }
            }
        }

        return true;
    }
}