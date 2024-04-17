package LeetCode;

public class _5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("aacabdkacaa"));

    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        String[] strArray = s.split("");
        String sCopyStr = s;
        boolean palindromeBollean = true;
        String templeResult = "";
        for (int i = 0; i < strArray.length; i++) {
            sCopyStr = sCopyStr.substring(i, sCopyStr.lastIndexOf(strArray[i]) + 1);
            String[] sCopyStrArray = sCopyStr.split("");
            int firstIndex = sCopyStr.indexOf(strArray[i]);
            int lastIndex = sCopyStr.lastIndexOf(strArray[i]);
//            while (firstIndex == lastIndex) {
//                sCopyStr.substring();
//                firstIndex = sCopyStr.indexOf(strArray[i]);
//                lastIndex = sCopyStr.lastIndexOf(strArray[i]);
//            }
            for (int j = 0; j < sCopyStrArray.length / 2; j++) {
                if (!sCopyStrArray[j].equals(sCopyStrArray[sCopyStrArray.length - j - 1])) {
                    palindromeBollean = false;
                    break;
                }
            }
            if (palindromeBollean && templeResult.length() < sCopyStr.length()) {
                templeResult = sCopyStr;
            }
            sCopyStr = s;
        }
        return templeResult;
    }
}