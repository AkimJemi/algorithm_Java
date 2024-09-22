package LeetCode;

public class _5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
//        System.out.println(new Solution5().longestPalindrome("abcdcbb"));
//        System.out.println(new Solution5().longestPalindrome("aabbcccbbee"));
//        System.out.println(new Solution5().longestPalindrome("ac"));
        System.out.println(new Solution5().longestPalindrome("aacabdkacaa"));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            String tmp = s.substring(i, s.lastIndexOf(cha) + 1);
            while (true) {
                boolean isLongest = true;
                String subStr = tmp.substring(0, tmp.lastIndexOf(cha) + 1);
                if (subStr.length() < longestPalindrome.length() || subStr.length() == 0) {
                    break;
                }
                String front = subStr.substring(0, subStr.length() / 2);
                String back = subStr.substring((subStr.length() % 2 == 0 ? subStr.length() : subStr.length() + 1) / 2, subStr.length());
                if (front.length() == back.length()) {
                    char[] frontAra = front.toCharArray();
                    char[] backAra = back.toCharArray();
                    for (int j = 0; j < front.length(); j++) {
                        if (frontAra[j] != backAra[frontAra.length - j - 1]) {
                            isLongest = false;
                            break;
                        }
                    }
                    if (isLongest && subStr.length() > longestPalindrome.length()) {
                        longestPalindrome = subStr;
                    }
                }
                if (subStr.length() < longestPalindrome.length() || tmp.lastIndexOf(cha) == 0) {
                    break;
                }
                tmp = tmp.substring(0, tmp.lastIndexOf(cha));
            }
        }
        return longestPalindrome;
    }

    // others code
    public int start = 0;
    public int end = 0;

    private void palindrome(char[] ch, int i) {
        int l = i;
        int r = i;
        int n = ch.length;
        if (i >= n - 1)
            return;
        while (r < n - 1 && ch[r] == ch[r + 1]) {
            r++;
        }
        i = r;
        while (l > 0 && r < n - 1 && ch[l - 1] == ch[r + 1]) {
            l--;
            r++;
        }
        if ((end - start) < (r - l)) {
            end = r;
            start = l;
        }
        palindrome(ch, i + 1);
    }

    public String longestPalindrome2(String s) {
        char[] ch = s.toCharArray();
        palindrome(ch, 0);
        return s.substring(start, end + 1);
    }

//    public String longestPalindrome(String s) {
//        String[] strArray = s.split("");
//        String sCopyStr = s;
//        boolean palindromeBollean = true;
//        String templeResult = "";
//        for (int i = 0; i < strArray.length; i++) {
//            sCopyStr = sCopyStr.substring(i, sCopyStr.lastIndexOf(strArray[i]) + 1);
//            String[] sCopyStrArray = sCopyStr.split("");
//            int firstIndex = sCopyStr.indexOf(strArray[i]);
//            int lastIndex = sCopyStr.lastIndexOf(strArray[i]);
////            while (firstIndex == lastIndex) {
////                sCopyStr.substring();
////                firstIndex = sCopyStr.indexOf(strArray[i]);
////                lastIndex = sCopyStr.lastIndexOf(strArray[i]);
////            }
//            for (int j = 0; j < sCopyStrArray.length / 2; j++) {
//                if (!sCopyStrArray[j].equals(sCopyStrArray[sCopyStrArray.length - j - 1])) {
//                    palindromeBollean = false;
//                    break;
//                }
//            }
//            if (palindromeBollean && templeResult.length() < sCopyStr.length()) {
//                templeResult = sCopyStr;
//            }
//            sCopyStr = s;
//        }
//        return templeResult;
//    }
}