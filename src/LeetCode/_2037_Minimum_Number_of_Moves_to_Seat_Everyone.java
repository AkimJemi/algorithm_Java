package LeetCode;

import java.util.Arrays;

public class _2037_Minimum_Number_of_Moves_to_Seat_Everyone {
    public static void main(String[] args) {
        System.out.println(new Solution2037().minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        System.out.println(new Solution2037().minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}));
        System.out.println(new Solution2037().minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));
    }
}

class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        if (seats.length == 1) {
            return Math.abs(students[0] - seats[0]);
        }
        Arrays.sort(seats);
        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            int target = students[i];
            Integer bef = null;
            Integer aft = null;
            for (int j = 0; j < seats.length - 1; j++) {
                if (seats[j] == -1) {
                    if (j == seats.length - 2) {
                        answer += Math.min(bef == null ? Math.abs(target - seats[j]) : bef, aft == null ? Math.abs(target - seats[j + 1]) : aft);
                        break;
                    }
                    continue;
                }
                bef = Math.abs(target - seats[j]);
                if (seats[j + 1] == -1) {
                    if (j == seats.length - 2) {
                        answer += Math.min(bef, aft == null ? Math.abs(target - seats[j + 1]) : aft);
                        break;
                    }
                    continue;
                }
                aft = Math.abs(target - seats[j + 1]);
                if (bef <= aft) {
                    answer += bef;
                    seats[j] = -1;
                    break;
                }
                if (j == seats.length - 2) {
                    answer += aft;
                    seats[j + 1] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}