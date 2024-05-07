package Programmers.Level1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 숫자_짝꿍 {
    public static void main(String[] args) {
        System.out.println(new Solution숫자_짝꿍().solution("100", "2345"));
        System.out.println(new Solution숫자_짝꿍().solution("100", "203045"));
        System.out.println(new Solution숫자_짝꿍().solution("100", "123450"));
        System.out.println(new Solution숫자_짝꿍().solution("12321", "42531"));
        System.out.println(new Solution숫자_짝꿍().solution("5525", "1255"));
        System.out.println(new Solution숫자_짝꿍().solution("0", "0"));
    }
}

class Solution숫자_짝꿍 {
    public String solution(String X, String Y) {
        String min = X;
        String max = Y;
        if (X.compareTo(Y) == 1) {
            max = X;
            min = Y;
        }
        Map<String, Long> maxCollect = Arrays.stream(max.split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        Map<String, Long> minCollect = Arrays.stream(min.split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Long> str : minCollect.entrySet()) {
            if (maxCollect.containsKey(str.getKey())) {
                if (maxCollect.get(str.getKey()) > str.getValue()) {
                    stringBuilder.append(str.getKey().repeat(Math.toIntExact(str.getValue())));
                } else {
                    stringBuilder.append(str.getKey().repeat(Math.toIntExact(maxCollect.get(str.getKey()))));
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "-1";
        } else if (Long.valueOf(stringBuilder.toString()) == 0) {
            return "0";
        }
        return stringBuilder.reverse().toString();
    }
}

/*
 *Someone else's code to study
 * */