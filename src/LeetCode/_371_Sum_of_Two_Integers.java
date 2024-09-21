package LeetCode;

import java.math.BigInteger;

public class _371_Sum_of_Two_Integers {
    public static void main(String[] args) {
        System.out.println(new Solution_371_Sum_of_Two_Integers().getSum(102, 199));
    }
}

class Solution_371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}