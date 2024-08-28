package LeetCode;

import java.util.stream.IntStream;

public class _168_Excel_Sheet_Column_Title {
    public static void main(String[] args) {

//        System.out.println(new Solution168().convertToTitle(1));
//        System.out.println(new Solution168().convertToTitle(2));
//        System.out.println(new Solution168().convertToTitle(26));
//        System.out.println(new Solution168().convertToTitle(26)); // Z
//        System.out.println(new Solution168().convertToTitle(27)); // AA
//        System.out.println(new Solution168().convertToTitle(28)); // AB
//        System.out.println(new Solution168().convertToTitle(52)); // AZ
//        System.out.println(new Solution168().convertToTitle(53)); // BA ? B[
//        System.out.println(new Solution168().convertToTitle(54)); // BB
//        System.out.println(new Solution168().convertToTitle(70)); // AB
        IntStream.rangeClosed(701, 707).forEach(a -> System.out.println(a + ": " + new Solution168().convertToTitle(a)));
    }
}

class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sp = new StringBuilder();
        if (columnNumber % 26 != 0) {
            sp.insert(0, String.valueOf((char) (columnNumber % 26 + 64)));
        } else {
            sp.insert(0, String.valueOf((char) (26 + 64)));
        }
        columnNumber -= 26;
//        columnNumber -= (26 * 26);
//        if (columnNumber > 0) {
            if (columnNumber % 26 != 0) {
                sp.insert(0, String.valueOf((char) (columnNumber / 26 + 65)));
            } else {
                sp.insert(0, String.valueOf((char) (columnNumber / 27 + 65)));
            }
//        }
//        columnNumber -= (26 * 26 * 26);
//        if (columnNumber > 0) {
        if (columnNumber % 26 != 0) {
            sp.insert(0, String.valueOf((char) (columnNumber / 26 + 65)));
        } else {
            sp.insert(0, String.valueOf((char) (columnNumber / 27 + 65)));
        }
//        }
        return sp.toString();
    }
//        if (columnNumber % 26 != 0) {
//        } else {
//            sp.insert(0, String.valueOf((char) (26 + 64)));
//        }
//        if (columnNumber / 27 != 0) {
//        sp.insert(0, String.valueOf((char) (columnNumber / 26 + 65)));
//        }
//        } else {
//            sp.insert(sp.length(), String.valueOf((char) (columnNumber / 27 + 64)));
//        }
//        sp.insert(sp.length(), String.valueOf((char) (columnNumber / 26 + 64)));
//        for(int )
//        while (columnNumber > 0) {
//            answer += String.valueOf((char) (columnNumber % 27 + 64));
//            columnNumber -= (columnNumber % 27) * 26 * count;
//            count = count * 26;
//            columnNumber /= 26;
//            answer += String.valueOf((char) (columnNumber + 64));
//            System.out.println((char) (columnNumber + 64));
//        }
}