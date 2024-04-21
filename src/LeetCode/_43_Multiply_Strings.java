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
        String resultStr = "0";
        for (int i = 0; i < num1.length(); i++) {
            String num1Str = String.valueOf(num1.charAt(i));
            for (int j = 0; j < num1.length(); j++) {
                int place = i + j;
//                System.out.println(place);
                int num = ((int) num1.charAt(i) - '0') * ((int) num2.charAt(j) - '0');
                System.out.println(num);
                if (num >= 10) {

                } else {
                    int targetInt = 0;
                    if (resultStr.length() < place + 1) {
                        targetInt = Integer.valueOf((int) resultStr.charAt(place) - '0');
                    } else {
                        targetInt = Integer.valueOf(resultStr.substring(place, place + 1));
                    }
                    System.out.println(targetInt);

                }
                if (resultStr.length() > place + 1) {
                    int targetInt = Integer.valueOf(resultStr.substring(place, place + 2));
                    int valueTargetAndNum = num + targetInt;
                    System.out.println(valueTargetAndNum);
                    if (valueTargetAndNum >= 100) {

                        if (resultStr.length() > place + 2) {

                        } else {

                        }
                    }
                }
            }
        }
        return String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2));
    }

    String plus(String numTarget1, String numTarget2, int index) {
        return null;
    }
}