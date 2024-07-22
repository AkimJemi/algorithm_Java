package LeetCode;

public class _258_Add_Digits {
    public static void main(String[] args) {
        System.out.println(new Solution285().addDigits2(38));
    }
}

class Solution285 {
    // mycode
    public int addDigits(int num) {
        int sum = 0;
        while (true) {
            for (String numStr : String.valueOf(num).split("")) {
                sum += Integer.valueOf(numStr);
            }
            if (sum < 10) return sum;
            else {
                num = sum;
                sum = 0;
            }
        }
    }

    // others code
    public int addDigits2(int num) {
        //return if the number is == 0 or the number is less
        //then 10 (which can be called as single digit)
        if (num == 0 || num < 10) {
            return num;
        }
        int sum = 0;
        //first add all the digits
        while (num > 0) {
            int temp = num % 10;
            sum = sum + temp;
            num = num / 10;
        }
        //then pass the added sum as input in recursion
        return addDigits(sum);
    }
}