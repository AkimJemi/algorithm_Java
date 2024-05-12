package Programmers.Level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 정답률70퍼센트이상문제들 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
        System.out.println(new Solution최소직사각형().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(new Solution최소직사각형().solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(new Solution최소직사각형().solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}

class Solution최소직사각형 {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (max < (sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1]))
                max = (sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1]);
            if (min < (sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1]))
                min = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
        }
        return max * min;
    }

    /*
     *Someone else's code to study
     * */
    public int solution2(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }

    public int solution3(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }

}

class Solution없는_숫자_더하기 {
    public int solution(int[] numbers) {
        int sum = 0;
        for (int num : numbers)
            sum += num;
        return 45 - sum;
    }
}

class Solution나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        return IntStream.range(2, n).filter(a -> n % a == 1).findFirst().getAsInt();
    }
}

class Solution문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        int pCount = 0;
        int sCount = 0;
        for (Character cha : s.toCharArray()) {
            pCount = cha == 'p' || cha == 'P' ? pCount + 1 : pCount;
            sCount = cha == 'y' || cha == 'Y' ? sCount + 1 : sCount;
        }
        return pCount == sCount;
    }

    /*
     *Someone else's code to study
     * */
    boolean solution2(String s) {
        s = s.toUpperCase();
        return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
    }

    boolean solution3(String s) {
        return s.replaceAll("[^yY]", "").length() - s.replaceAll("[^pP]", "").length() == 0 ? true : false;
    }
}

