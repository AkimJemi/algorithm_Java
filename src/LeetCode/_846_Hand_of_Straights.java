package LeetCode;

import java.util.Arrays;

public class _846_Hand_of_Straights {
    public static void main(String[] args) {
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
//        System.out.println(new Solution846().isNStraightHand(new int[]{1}, 1));
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4}, 4) == true);
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4) == false);
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 4) == false);
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5, 6, 7}, 4) == false);
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4) == true);
//        System.out.println(new Solution846().isNStraightHand(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4) == false);
        System.out.println(new Solution846().isNStraightHand(new int[]{0, 1}, 2));
    }
}

class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) return true;
        byte[] byteArray = new byte[Arrays.stream(hand).max().getAsInt()];
        if (byteArray.length < groupSize) return false;
        for (int i = 0; i < hand.length; i++) byteArray[hand[i] - 1]++;
        int start = 0;
        while (true) {
            for (int i = start; i < start + groupSize; i++) {
                if (start == byteArray.length - groupSize) {
                    for (int j = start; j < groupSize + start - 1; j++) {
                        if (byteArray[j] != byteArray[j + 1]) return false;
                    }
                    return true;
                }
                if (i == start && byteArray[i] == 0) {
                    start++;
                    continue;
                }
                if (byteArray[i] != 0) {
                    byteArray[i]--;
                }
            }
        }
    }
}