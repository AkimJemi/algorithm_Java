package Programmers.Level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
//        System.out.println(new Solution로또의_최고_순위와_최저_순위().solution(""));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{6, 5, 0, 0, 4, 0}, new int[]{4, 1, 2, 0, 7, 8})));
    }
}

class Solution로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottosList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int max = 0;
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottosList.remove((Integer) 0)) {
                max++;
                continue;
            }
            if (winNumsList.contains(lottosList.get(0))) count++;
            lottosList.remove(0);
        }
        return new int[]{7 - count - max != 7 ? 7 - count - max : 6, 7 - count != 7 ? 7 - count : 6};
    }
}

/*
 *Someone else's code to study
 * */