package Programmers.Level2;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class _383_Ransom_Note {
    public static void main(String[] args) {
        System.out.println(canConstruct("abdvb", "defegagagwgaw"));
    }

    private static boolean ransomNote(String ransomNote, String magazine) {
        for (char cha : ransomNote.toCharArray()) {
            if (magazine.contains(String.valueOf(cha))) {
                magazine = magazine.replaceFirst(String.valueOf(cha), "");
            } else {
                return false;
            }
        }
        return true;
    }

    // others code
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        int[] alphabets = new int[26];
        for(char ch: ransomNote.toCharArray()){
            int index = magazine.indexOf(ch, alphabets[ch - 'a']);

            if(index == -1)
                return false;
            alphabets[ch - 'a'] = index + 1;
        }

        return true;
    }
}
