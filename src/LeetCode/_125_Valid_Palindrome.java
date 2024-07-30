package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class _125_Valid_Palindrome {
    public static void main(String[] args) {
//        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Solution125().isPalindrome("abcddxcba"));
//        System.out.println(new Solution125().isPalindrome("abcdcba"));
        System.out.println(new Solution125().isPalindrome("0P"));
    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str += c;
            }
        }
        int leftStartIndex = str.length() / 2;
        if (str.length() % 2 != 0) {
            leftStartIndex = leftStartIndex + 1;
        }
        return str.substring(leftStartIndex, str.length()).equals(new StringBuffer(str.substring(0, str.length() / 2)).reverse().toString());
    }


    // others code
    public boolean isPalindrome2(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left <= right) {
            char leftChar = toLowercase(s.charAt(left));
            char rightChar = toLowercase(s.charAt(right));
            if (!isValid(leftChar)) {
                left++;
            } else if (!isValid(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                right--;
                left++;
            }
        }
        return true;
    }

    private char toLowercase(char c) {
        if (c >= 'A' && c <= 'Z')
            return (char) ('a' + (c - 'A'));
        else
            return c;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}