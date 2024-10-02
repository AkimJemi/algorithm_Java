package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1497_Check_If_Array_Pairs_Are_Divisible_by_k {
    public static void main(String[] args) {
        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange2(new int[]{3, 8, 17, 2, 5, 6}, 10));
//        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
//        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
//        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange(new int[]{-10, 10}, 2));
//        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange(new int[]{5, 5, 1, 2, 3, 4}, 10));
//        System.out.println(new Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k().canArrange(new int[]{-1, -1, -1, -1, 2, 2, -2, -2}, 3));

    }
}

class Solution_1497_Check_If_Array_Pairs_Are_Divisible_by_k {
    public boolean canArrange(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            if (right <= left) {
                break;
            }
            int pairSum = list.get(left) + list.get(right);
            if (pairSum % k == 0) {
                list.remove(right);
                list.remove(left);
                right = list.size() - 1;
                if (right < 0) {
                    break;
                }
                continue;
            }
            right--;
        }
        return list.size() == 0;
    }

    // ChatGPT
    public boolean canArrange2(int[] arr, int k) {
        // Frequency array to count occurrences of each remainder
        int[] remainderCounts = new int[k];

        // Count remainders for each element in the array
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;  // Handle negative numbers
            remainderCounts[remainder]++;
        }

        // Check pairs for remainder 0
        if (remainderCounts[0] % 2 != 0) {
            return false;  // Remainder 0 elements must have even count to pair with themselves
        }

        // Check pairs for other remainders
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCounts[i] != remainderCounts[k - i]) {
                return false;  // Remainder i must pair with remainder k-i
            }
        }

        return true;  // All pairs can be formed
    }
}