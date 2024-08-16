package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class _506_Relative_Ranks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution506().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }
}

class Solution506 {

    // mycode
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(-score[i], i);
        }
        String[] result = new String[score.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i != 0 && i != 1 && i != 2) {
                result[entry.getValue()] = i + 1 + "";
            } else if (i == 0) {
                result[entry.getValue()] = "Gold Medal";
            } else if (i == 1) {
                result[entry.getValue()] = "Silver Medal";
            } else if (i == 2) {
                result[entry.getValue()] = "Bronze Medal";
            }
            i++;
        }
        return result;
    }


    private int findMax(int[] score) {
        int maxScore = 0;
        for (int s : score) {
            if (s > maxScore) {
                maxScore = s;
            }
        }
        return maxScore;
    }

    // other code
    public String[] findRelativeRanks2(int[] score) {
        int N = score.length;

        // Add the original index of each score to the array
        // Where the score is the key
        int M = findMax(score);
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        // Assign ranks to athletes
        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = MEDALS[place - 1];
                } else {
                    rank[originalIndex] = String.valueOf(place);
                }
                place++;
            }
        }
        return rank;
    }
}