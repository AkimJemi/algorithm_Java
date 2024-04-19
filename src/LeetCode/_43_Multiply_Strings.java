package LeetCode;

import java.math.BigInteger;
import java.util.Arrays;

public class _43_Multiply_Strings {
    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("244", "2555"));

    }
}

class Solution43 {
    public String multiply(String num1, String num2) {
//        for (int i = 0; i < num1.length(); i++) {
//            String num1Str = String.valueOf(num1.charAt(i));
//            for (int j = 0; j < num1.length(); j++) {
//                int place = i + j;
//                String num2Str = String.valueOf(num2.charAt(j));
//                System.out.println(num1Str + ", " + num2Str);
//                System.out.println(num1Str + num2Str);
//            }
//        }
        return String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2));
    }

    String plus(String numTarget1, String numTarget2, int index) {
        return null;
    }
}