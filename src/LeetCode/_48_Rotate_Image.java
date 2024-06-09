package LeetCode;

import java.util.Arrays;

public class _48_Rotate_Image {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(matrix).replaceAll("\\]", "\r\n").replaceAll(", \\[", "").replaceAll("\\[\\[", ""));
        new Solution48().rotate(
                new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
        new Solution48().rotate(
                new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        int loopVal = 0;
        for (int n = 0; n < matrix.length / 2; n++) {
            int[] firArr = Arrays.copyOfRange(matrix[start], start, end + 1);
            for (int i = start; i < end; i++) {
                matrix[start][end - i + loopVal] = matrix[i][start];
                matrix[i][start] = matrix[end][i];
                matrix[end][i] = matrix[end - i + loopVal][end];
                matrix[end - i + loopVal][end] = firArr[end - i];
            }
            start++;
            end--;
            loopVal++;
        }
    }
}