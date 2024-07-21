package LeetCode;

import java.util.Arrays;

public class _202_Happy_Number {
    public static void main(String[] args) {
//        System.out.println(new Solution202().isHappy(2));
//        System.out.println(new Solution202().isHappy(1111111));
        System.out.println(new Solution202().isHappy(7));
    }
}

class Solution202 {
    public boolean isHappy(int n) {
        int sum = 0;
        do {
            sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        } while (sum >= 10);
        return sum == 1 || sum == 7 ? true : false;
    }

    public boolean isHappy2(int n) {
        String str = String.valueOf(n);
        while (!str.equals("0") && !str.equals("2") && !str.equals("3") && !str.equals("4") && !str.equals("6") && !str.equals("8") && !str.equals("9")) {
            str = String.valueOf(Arrays.stream(str.split("")).map(a -> Integer.valueOf(a) * Integer.valueOf(a)).reduce((a, b) -> a + b).get());
            if (str.length() == 1 && (str.equals("1") || str.equals("7"))) {
                return true;
            }
        }
        return false;
    }


    // others code
    public boolean isHappy3(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int last = n % 10;
                sum += (last * last);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}