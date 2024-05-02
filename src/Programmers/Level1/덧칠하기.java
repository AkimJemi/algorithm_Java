package Programmers.Level1;

import java.util.Arrays;

public class 덧칠하기 {
    public static void main(String[] args) {
        System.out.println(new Solution_덧칠하기().solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(new Solution_덧칠하기().solution(5, 4, new int[]{1, 3}));
        System.out.println(new Solution_덧칠하기().solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}

class Solution_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int[] map = new int[n];
        for (int j = 0; j < section.length; j++) {
            for (int i = 1; i <= n; i++) {
                if (section[j] == i) {
                    map[i - 1]++;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                count++;
                for (int j = 0; j < m; j++) {
                    if (i + j >= map.length) {
                        break;
                    }
                    map[i + j]--;
                }
            }
        }
        return count;
    }
}