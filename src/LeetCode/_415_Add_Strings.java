package LeetCode;

public class _415_Add_Strings {
    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("11", "10"));
        System.out.println(new Solution415().addStrings("91", "9"));
        System.out.println(new Solution415().addStrings("1", "9"));
        System.out.println(new Solution415().addStrings("2", "8"));
    }
}

class Solution415 {

    // mycode
    public String addStrings(String num1, String num2) {
        String maxStr = num1.length() > num2.length() ? num1 : num2;
        String minStr = num1.length() <= num2.length() ? num1 : num2;
        int maxLength = maxStr.length();
        String sum = "";
        boolean tenFlag = false;
        int ten = 0;
        for (int i = minStr.length() - 1; i >= 0; i--) {
            int num = Integer.valueOf(String.valueOf(minStr.charAt(i))) + Integer.valueOf(String.valueOf(maxStr.charAt(maxLength - 1))) + ten;
            if (num >= 10) tenFlag = true;
            else tenFlag = false;
            sum = (tenFlag ? (num - 10) : num) + sum;
            maxLength--;
            if (tenFlag) ten = 1;
            else ten = 0;
        }
        for (int i = maxLength - 1; i >= 0; i--) {
            int num = Integer.valueOf(String.valueOf(maxStr.charAt(i))) + ten;
            if (num >= 10) tenFlag = true;
            else tenFlag = false;
            sum = (tenFlag ? (num - 10) : num) + sum;
            if (tenFlag) ten = 1;
            else ten = 0;
        }
        return (tenFlag ? ten : "") + sum;
    }

    // others code
    public String addStrings2(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}