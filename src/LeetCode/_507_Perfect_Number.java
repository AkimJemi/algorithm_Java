package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _507_Perfect_Number {
    public static void main(String[] args) {
//        System.out.println(new Solution507().checkPerfectNumber(28));
//        System.out.println(new Solution507().checkPerfectNumber(6));
        System.out.println(new Solution507().checkPerfectNumber(1));

    }
}

class Solution507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                if (list.contains(i)) {
                    break;
                }
                list.add(i);
                list.add(num / i);
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum == num;
    }

    // other code
    public boolean checkPerfectNumber2(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public boolean checkPerfectNumber3(int num) {
        if (num < 2) {
            return false;
        }
        if (num % 2 != 0) {
            return false;
        }
        int sum = 1;
        int max = num;
        for (int i = 2; i < max; i++) {
            if (num % i == 0) {
                sum += i;
                int otherDivisor = num / i;
                if (otherDivisor != i) {
                    sum += otherDivisor;
                }
                max = otherDivisor;
            }
        }
        return sum == num;
    }
}