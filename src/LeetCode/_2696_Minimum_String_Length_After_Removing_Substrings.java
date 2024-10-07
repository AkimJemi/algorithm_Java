package LeetCode;

import java.util.Arrays;

public class _2696_Minimum_String_Length_After_Removing_Substrings {
    public static void main(String[] args) {
//        System.out.println(new Solution_2696_Minimum_String_Length_After_Removing_Substrings().minLength("ABFCACDB"));
//        System.out.println(new Solution_2696_Minimum_String_Length_After_Removing_Substrings().minLength("ACBBD"));
//        System.out.println(new Solution_2696_Minimum_String_Length_After_Removing_Substrings().minLength("AATQCABDCBE"));
        System.out.println(new Solution_2696_Minimum_String_Length_After_Removing_Substrings().minLength("BJKDKABJ"));

    }
}

class Solution_2696_Minimum_String_Length_After_Removing_Substrings {
    public int minLength(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            if ((array[i] == 65 && array[j] == 66) || (array[i] == 67 && array[j] == 68)) {
                array[i] = 0;
                array[j] = 0;
                count += 2;
                while (true) {
                    if (i == -1 || j == array.length) {
                        i = j - 1;
                        break;
                    }
                    if (array[i] == 0) {
                        i--;
                        continue;
                    }
                    if (array[j] == 0) {
                        j++;
                        continue;
                    }
                    if ((array[i] == 65 && array[j] == 66) || (array[i] == 67 && array[j] == 68)) {
                        array[i] = 0;
                        array[j] = 0;
                        count += 2;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        return array.length - count;
    }

    // others code
    public int minLength2(String s) {
        char[] stack = new char[s.length() + 1];
        int last = -1;
        for (char c : s.toCharArray()) {
            if (last > -1 && (c == 'B' && stack[last] == 'A' ||
                    c == 'D' && stack[last] == 'C')) {
                last--;
            } else {
                last++;
                stack[last] = c;
            }
        }
        return last + 1;
    }
}