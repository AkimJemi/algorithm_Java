package Programmers.Level3;

import java.util.Arrays;

class 정수_삼각형 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
//        System.out.println(new Solution정수_삼각형().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
        System.out.println(new Solution정수_삼각형().solution(new int[][]{{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}, {11, 12, 13, 14, 15}}));
    }
}

class Solution정수_삼각형 {
    public int solution(int[][] triangle) {
        System.out.println(Arrays.toString(recursion(triangle, 0, 0, triangle[0][0], 0)));
//        for (int i = 0; i < triangle.length; i++) {
//            int[] innerArray = triangle[i];
//            for (int j = 0; j < innerArray.length; j++) {
//                int innerNum = innerArray[j];
//                System.out.println(innerNum);
//            }
//            if (i == triangle.length - 1) {
//                System.out.println();
//            }
//
//        }
        int answer = 0;
        return answer;
    }

    int[] recursion(int[][] triangle, int i, int j, int a, int b) {
        if (j == 0) {
            return recursion(triangle, i, j + 1, triangle[i][j] + a, 0);
        }
        if (j == triangle[i].length - 2) {
            i++;
            j = 0;
        }
        return recursion(triangle, i, j + 1, triangle[i][j] + a, triangle[i][j + 1] + b);
    }
}

/*
 *Someone else's code to study
 * */