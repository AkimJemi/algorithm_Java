package Programmers.Level1;

import java.util.Arrays;

public class 바탕화면_정리 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{".#...", "..#..", "...#."})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
    }

    static class Solution {
        public int[] solution(String[] wallpaper) {
            Integer firstYIndex = null;
            Integer lastYIndex = null;
            Integer firstXIndex = null;
            Integer lastXIndex = null;
            for (int i = 0; i < wallpaper.length; i++) {
                String str = wallpaper[i];
                int firstIndex = str.indexOf("#");
                int lastIndex = str.lastIndexOf("#");
                if (firstIndex != -1 && firstXIndex == null) {
                    firstXIndex = firstIndex;
                }
                if (lastIndex != -1 && lastXIndex == null) {
                    lastXIndex = lastIndex;
                }
                if (firstIndex != -1 && firstXIndex != null && firstIndex < firstXIndex) {
                    firstXIndex = firstIndex;
                }
                if (lastIndex != -1 && lastXIndex != null && lastIndex > lastXIndex) {
                    lastXIndex = lastIndex;
                }
                if (firstIndex != -1 && firstYIndex == null) {
                    firstYIndex = i;
                }
                if (firstIndex != -1) {
                    lastYIndex = i;
                }
            }
            return new int[]{firstYIndex, firstXIndex, lastYIndex + 1, lastXIndex + 1};
        }
    }
    public int[] solution_바탕화면_다른_사람의_풀이(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}

