package LeetCode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _66_Plus_One {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{1, 2, 3})));
//        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{4, 3, 2, 1})));
//        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{9, 9})));
    }
}

class Solution66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[digits.length - 1 - i] >= 10) {
                digits[digits.length - 1 - i] = digits[digits.length - 1 - i] - 10;
                if (i != digits.length - 1) {
                    digits[digits.length - 2 - i] += 1;
                } else {
                    int[] intArray = new int[digits.length + 1];
                    intArray[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        intArray[j + 1] = digits[j];
                    }
                    return intArray;
                }
                continue;
            }
            return digits;
        }
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        return Arrays.stream(String.valueOf(Integer.valueOf(Arrays.stream(digits).boxed().map(String::valueOf).collect(Collectors.joining())) + 1).split("")).mapToInt(Integer::valueOf).toArray();
    }
}
