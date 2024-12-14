package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
        System.out.println(Arrays.toString(solution(3, new String[]{"abc", "cbd", "ddd", "ddd", "dbc", "cbd"})));

    }

    public static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int round = 1;
        for (int i = 1; i < words.length; i++) {
            if (i % n == 0) {
                round++;
            }
            String fir = words[i - 1];
            String sec = words[i];
            if (list.contains(sec) || fir.charAt(fir.length() - 1) != sec.charAt(0)) {
                return new int[]{i % n + 1, round};
            }
            list.add(sec);
        }
        return new int[]{0, 0};
    }
}
