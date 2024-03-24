import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        String targetStr = "";
        char[] targetCharArray = null;
        for (String str : strs) {
            char[] prefixArray = new char[str.length()];
            if (targetStr.length() == 0) {
                targetCharArray = str.toCharArray();
                System.out.println("continue;");
                continue;
            }
            int i = 0;
            for (Character cha : str.toCharArray()) {
                System.out.println(cha.equals(targetCharArray[i]));
                if (cha.equals(targetCharArray[i])) {
                    targetStr += String.valueOf(cha);
                } else {
                }
                i++;
            }
            if (prefix.length() == 0) {
                System.out.println("break;");
                break;
            }
        }
        return "";
    }
}