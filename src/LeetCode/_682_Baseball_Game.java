package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _682_Baseball_Game {
    public static void main(String[] args) {
        System.out.println(new Solution682().calPoints(new String[]{"5", "2", "C", "D", "+"}));

    }
}

class Solution682 {
    // mycode
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            if (str.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else if (str.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (str.equals("C")) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.valueOf(operations[i]));
            }
        }
        return list.stream().mapToInt(i -> i).sum();
    }

    // other code
    public int calPoints2(String[] operations) {
        int n = operations.length;
        int[] temp = new int[n];
        int idx = 0;
        for (String op : operations) {
            if (op.equals("C")) {
                temp[--idx] = 0;
            } else if (op.equals("D")) {
                temp[idx] = temp[idx - 1] * 2;
                idx++;
            } else if (op.equals("+")) {
                temp[idx] = temp[idx - 1] + temp[idx - 2];
                idx++;
            } else {
                temp[idx++] = Integer.parseInt(op);
            }
        }

        int ans = 0;
        for (int x : temp) {
            ans += x;
        }
        return ans;
    }
}