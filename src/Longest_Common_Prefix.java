public class Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"ab", "a"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                prefix = strs[i];
                continue;
            }
            if (strs[i].length() == 0) {
                return "";
            }
            char[] prefixCharArray = prefix.toCharArray();
            String strMiddle = "";
            for (int j = 0; j < prefixCharArray.length; j++) {
                if (String.valueOf(prefixCharArray[j]).equals(strs[i].substring(j, j + 1))) {
                    strMiddle += strs[i].substring(j, j + 1);
                } else {
                    break;
                }
                if (j + 1 == strs[i].length()) {
                    break;
                }
            }
            prefix = strMiddle;
        }
        return prefix;
    }
}