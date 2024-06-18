package LeetCode;

import java.util.Arrays;

public class _344_Reverse_String {
    public static void main(String[] args) {
        new Solution344().reverseString1(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

}

class Solution344 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }

    /* others code */
    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            // XOR swap algorithm
//            s[left] = (char)(s[left] ^ s[right]);
//            s[right] = (char)(s[left] ^ s[right]);
//            s[left] = (char)(s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right] ^ (s[right] = s[left]));
            left++;
            right--;
        }
    }

    public void reverseString2(char[] s) {
        helper(s, 0);
    }

    public void helper(char[] s, int idx) {
        int mid = (s.length + 1) >> 1;
        if (idx == mid) {
            return;
        }
        char temp = s[idx];
        s[idx] = s[s.length - 1 - idx];
        s[s.length - 1 - idx] = temp;
        helper(s, idx + 1);
    }
}