package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _567_Permutation_in_String {
    public static void main(String[] args) {
//        System.out.println(new Solution_567_Permutation_in_String().checkInclusion("ab", "eidbaooo"));
//        System.out.println(new Solution_567_Permutation_in_String().checkInclusion("ab", "eidboaoo"));
        System.out.println(new Solution_567_Permutation_in_String().checkInclusion("adc", "dcda"));
    }
}

class Solution_567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        int s1Length = s1.length();
        for (int i = 0; i < s2.length() - s1Length + 1; i++) {
            char[] char2Array = s2.substring(i, i + s1Length).toCharArray();
            Arrays.sort(char2Array);
            for (int j = 0; j < s1Array.length; j++) {
                if (s1Array[j] != char2Array[j]) {
                    break;
                }
                if (j == s1Array.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    // others code
    public static boolean checkInclusion2(String s1, String s2) {
        final int len1 = s1.length();
        final int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        final int[] counters = new int[26];
        for (int i = 0; i < len1; i++) {
            counters[s1.charAt(i) - 'a']++;
            counters[s2.charAt(i) - 'a']--;
        }

        int deltaCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counters[i] < 0) {
                deltaCount++;
            }
        }
        if (deltaCount == 0) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            final int removeC = s2.charAt(i - len1) - 'a';
            final int addC = s2.charAt(i) - 'a';

            counters[removeC]++;
            if (counters[removeC] == 0) {
                deltaCount--;
            }

            counters[addC]--;
            if (counters[addC] == -1) {
                deltaCount++;
            }

            if (deltaCount == 0) {
                return true;
            }
        }
        return false;
    }
}