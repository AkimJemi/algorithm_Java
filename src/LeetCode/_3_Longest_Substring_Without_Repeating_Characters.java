package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        List<String> strList = new ArrayList<>();
        List<String> strResultList = new ArrayList<>();
        String[] strArray = s.split("");
        for (int i = 0; i < s.length(); i++) {
            if (!strList.contains(strArray[i])) {
                strList.add(strArray[i]);
                if (strResultList.size() <= strList.size()) {
                    strResultList = new ArrayList<>();
                    strResultList.addAll(strList);
                }
                continue;
            }
            while (strList.contains(strArray[i])) {
                for (int j = 0; j <= strList.indexOf(strArray[i]); j++) {
                    strList.remove(0);
                }
            }
            strList.add(strArray[i]);
        }
        return strResultList.size();
    }
}