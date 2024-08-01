package LeetCode;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        System.out.println(new Solution121().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution121().maxProfit2(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Solution121().maxProfit2(new int[]{2, 4, 1}));


    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<>();
        int max = -1;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i]);
            if (prices[i] < min) {
                list.add(max - min);
                min = prices[i];
                max = -1;
            }
        }
        list.add(max - min);
        int result = list.stream().max(Comparator.naturalOrder()).get();
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    // others code
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > profit) profit = prices[i] - min;
        }
        return profit;
    }
}