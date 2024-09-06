package Programmers.Level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
//        System.out.println(new SolutionJadenCase_문자열_만들기().solution("3people unFollowed me"));
//        System.out.println(new SolutionJadenCase_문자열_만들기().solution("for the last week"));
        System.out.println(new SolutionJadenCase_문자열_만들기().solution("1 2D d2  33"));
        System.out.println(new SolutionJadenCase_문자열_만들기().solution("2 34 4 5 6 7 8 9 10 11 "));
        System.out.println(new SolutionJadenCase_문자열_만들기().solution(""));
        System.out.println(new SolutionJadenCase_문자열_만들기().solution("aAAAAbB CccccCS12      ba a"));
    }
}

class SolutionJadenCase_문자열_만들기 {
    public String solution(String s) {
        String[] array = s.split(" ", -1);
        String[] newArray = new String[array.length];
        int loop = 0;
        for (String str : array) {
            newArray[loop++] = str.length() != 0 ? str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase() : "";
        }
        return Arrays.stream(newArray).collect(Collectors.joining(" "));
    }
}