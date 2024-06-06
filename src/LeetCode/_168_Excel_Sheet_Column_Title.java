package LeetCode;

import org.junit.jupiter.api.Test;

public class _168_Excel_Sheet_Column_Title {
    @Test
    public void test() {
//        System.out.println(new Solution168().convertToTitle(1));
//        System.out.println(new Solution168().convertToTitle(2));
//        System.out.println(new Solution168().convertToTitle(26));
        System.out.println(new Solution168().convertToTitle(27));
        System.out.println(new Solution168().convertToTitle(28));
        System.out.println(new Solution168().convertToTitle(53));
        System.out.println(new Solution168().convertToTitle(54));
    }
}

class Solution168 {
    public String convertToTitle(int columnNumber) {
        String answer = "";
        int count = 1;
//        if (columnNumber < 27) {
//            answer += String.valueOf((char) (columnNumber % 27 + 64));
//            return answer;
//        }
        while (columnNumber > 0) {
            answer += String.valueOf((char) (columnNumber % 27 + 64));
            columnNumber -= (columnNumber % 27) * 26 * count;
            count = count * 26;
//            columnNumber /= 26;
//            answer += String.valueOf((char) (columnNumber + 64));
//            System.out.println((char) (columnNumber + 64));
        }
        return answer;
    }
}