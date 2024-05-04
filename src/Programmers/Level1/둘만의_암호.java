package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

/*
 *Someone else's code to study
 *
 *
 *
 * */
class Solution둘만의_암호1 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }
        return answer.toString();
    }
}

class Solution둘만의_암호2 {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char c : s.toCharArray()) {
            for (int i = index; i > 0; i--) {
                c++;
                if (c > 122) c -= 26;

                while (skip.contains(String.valueOf(c))) {
                    c++;
                    if (c > 122) c -= 26;
                }
            }
            answer += c;
        }
        return answer;
    }
}

class Solution둘만의_암호3 {
    public String solution(String s, String skip, int index) {
        String answer = "";
        //skip을 알파벳에서 없애고 시작하기.
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] delete = skip.split("");
        for (String d : delete) {
            alphabet = alphabet.replace(d, "");
        }
        String[] myalphabet = alphabet.split("");
        String[] sArr = s.split("");
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < myalphabet.length; j++) {
                if (sArr[i].equals(myalphabet[j])) {
                    answer += myalphabet[(j + index) % myalphabet.length];
                    continue;
                }
            }
        }
        return answer;
    }
}

class Solution둘만의_암호4 {
    public String solution(String s, String skip, int index) {
        return new StringGenerator(index, skip).generate(s);
    }

    private static class StringGenerator {
        private final Integer offsetIndex;
        private final Set<Character> skipCharacters;
        public StringGenerator(Integer offsetIndex, String skipCharacters) {
            this(offsetIndex, parseSkipCharacters(skipCharacters));
        }
        public StringGenerator(Integer offsetIndex, Set<Character> skipCharacters) {
            this.offsetIndex = offsetIndex;
            this.skipCharacters = skipCharacters;
        }
        public String generate(String base) {
            return base.chars()
                    .mapToObj(character -> (char) character)
                    .map(this::applyOffset)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
        private Character applyOffset(Character character) {
            int count = 0;
            Character applied = character;
            while (count < offsetIndex) {
                applied++;
                if (applied > 'z') {
                    applied = 'a';
                }
                if (skipCharacters.contains(applied)) {
                    continue;
                }
                count++;
            }
            return applied;
        }
        private static Set<Character> parseSkipCharacters(String skipCharacters) {
            return skipCharacters.chars()
                    .mapToObj(character -> (char) character)
                    .collect(Collectors.toSet());
        }
    }
}
