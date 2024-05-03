package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 둘만의_암호 {
    public static void main(String[] args) {
        System.out.println(new Solution둘만의_암호().solution("aukks", "wbqd", 5));
        System.out.println(new Solution둘만의_암호().solution("abcdefjklmuvwxyz", "", 5));
    }
}

class Solution둘만의_암호 {
    public String solution(String s, String skip, int index) {
        int zInt = 122;
        int aInt = 97;
        int[] map = new int[zInt + 1];
        for (char cha : skip.toCharArray()) {
            map[cha]++;
        }
        List<Integer> charList = new ArrayList<>();
        for (char cha : s.toCharArray()) {
            int targetChar = (int) cha;
            int targetCount = 0;
            while (true) {
                if (targetChar > zInt) {
                    targetChar = aInt;
                }
                if (map[targetChar] == 0) {
                    targetCount++;
                }
                if (targetCount == index + 1) {
                    break;
                }
                targetChar++;
            }
            charList.add(targetChar);
        }
        return charList.stream().mapToInt(Integer::valueOf).mapToObj(a -> String.valueOf((char) a)).
                collect(Collectors.joining());
    }
}