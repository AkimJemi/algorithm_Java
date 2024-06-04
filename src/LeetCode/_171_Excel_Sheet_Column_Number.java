package LeetCode;

public class _171_Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        System.out.println(new Solution171().titleToNumber1("ABC"));
    }
}

class Solution171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        char[] chaArray = columnTitle.toCharArray();
        for (int i = chaArray.length - 1; i >= 0; i--) {
            int mid = 1;
            for (int j = i; j < chaArray.length - 1; j++) {
                mid *= 26;
            }
            sum += ((int) chaArray[i] - 64) * mid;
        }
        return sum;
    }

    /*
     *Someone else's code to study
     * */
    public int titleToNumber1(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }
}