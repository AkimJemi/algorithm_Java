package Programmers.Level1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 햄버거_만들기 {
    public static void main(String[] args) {
        System.out.println(new Solution햄버거_만들기().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(new Solution햄버거_만들기().solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}

class Solution햄버거_만들기 {
    public int solution(int[] ingredient) {
        String hamburger = "1231";
        int count = 0;
        int one = 0;
        int oneTwo = 0;
        int oneTwoThree = 0;
        int oneTwoThreeOne = 0;
        for (int i = 0; i < ingredient.length - 3; i++) {
            if (ingredient[i] == 1) {
                if (ingredient[i + 1] == 1) {
                    one = 0;
                    one++;
                    i += 1;
                    continue;
                }
                if (ingredient[i + 1] == 2) {
                    if (ingredient[i + 2] == 3) {
                        if (ingredient[i + 3] == 1) {
                            oneTwoThreeOne++;
                            i += 3;
                            continue;
                        }
                        oneTwoThree++;
                        i += 2;
                        continue;
                    }
                    oneTwo++;
                    i += 1;
                    continue;
                }
                one++;
                continue;
            }
            if (ingredient[i] == 2) {
                if (one == 0) {
                    continue;
                }
                if (ingredient[i + 1] == 2) {
                    one = 0;
                    oneTwo = 0;
                    oneTwoThree = 0;
                    oneTwoThreeOne = 0;
                    i += 1;
                    continue;
                }
                if (ingredient[i + 1] == 1) {
                    one = 0;
                    oneTwo = 0;
                    oneTwoThree = 0;
                    oneTwoThreeOne = 0;
                    i += 1;
                    continue;
                }
                if (ingredient[i + 1] == 3) {
                    if (ingredient[i + 2] == 1) {
                        one--;
                        oneTwoThreeOne++;
                        i += 2;
                        continue;
                    }
                    if (ingredient[i + 2] == 2) {
                        one = 0;
                        oneTwo = 0;
                        oneTwoThree = 0;
                        oneTwoThreeOne = 0;
                        i += 2;
                        continue;
                    }
                    if (ingredient[i + 2] == 3) {
                        one = 0;
                        oneTwo = 0;
                        oneTwoThree = 0;
                        oneTwoThreeOne = 0;
                        i += 2;
                        continue;

                    }
                }
            }
            if (ingredient[i] == 3) {
                if (ingredient[i + 1] == 1) {


                }
            }
        }
        return oneTwoThreeOne;
    }

    public int solution2(int[] ingredient) {
        String hamburger = "1231";
        String joiningStr = Arrays.stream(ingredient).mapToObj(String::valueOf).collect(Collectors.joining());
        Matcher pattern = Pattern.compile(hamburger).matcher(joiningStr);
        int count = 0;
        while (pattern.find()) {
            count++;
            joiningStr = joiningStr.replaceFirst(hamburger, "");
            pattern = Pattern.compile(hamburger).matcher(joiningStr);
        }
        return count;
    }

    public int solutio1(int[] ingredient) {
        String hamburger = "1231";
        String joiningStr = Arrays.stream(ingredient).mapToObj(String::valueOf).collect(Collectors.joining());
        int count = 0;
        while (joiningStr.contains(hamburger)) {
            count++;
            joiningStr = joiningStr.replaceFirst(hamburger, "");
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */