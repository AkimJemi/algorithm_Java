package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class _917_Reverse_Only_Letters {
    public static void main(String[] args) {
//        System.out.println(new Solution917().reverseOnlyLetters("ab-cd"));
//        System.out.println(new Solution917().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(new Solution917().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

class Solution917 {
    public String reverseOnlyLetters(String s) {
        Map<Integer, Character> nonEnglish = new TreeMap<>();
        ;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Character cha : s.toCharArray()) {
            int charInt = (int) cha;
            if (!((charInt >= 65 && charInt <= 90) || (charInt >= 97 && charInt <= 122))) {
                nonEnglish.put(i, cha);
            } else {
                stringBuilder.append(cha);
            }
            i++;
        }

        stringBuilder = new StringBuilder(stringBuilder).reverse();
        for (Map.Entry<Integer, Character> entry : nonEnglish.entrySet()) {
            if (entry.getKey() >= stringBuilder.length()) {
                stringBuilder.append(entry.getValue());
            } else {
                stringBuilder.insert(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return stringBuilder.toString();
    }

    public String reverseOnlyLetters2(String s) {
        char[] charArr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (Character.isLetter(charArr[i]) && Character.isLetter(charArr[j])) {
                char temp = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = temp;
                i++;
                j--;
            } else if (!Character.isLetter(charArr[i])) {
                i++;
            } else {
                j--;
            }
        }

        return String.valueOf(charArr);
    }
}
