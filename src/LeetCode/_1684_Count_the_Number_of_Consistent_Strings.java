package LeetCode;

public class _1684_Count_the_Number_of_Consistent_Strings {
    public static void main(String[] args) {
        System.out.println(new Solution_1684_Count_the_Number_of_Consistent_Strings().countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}

class Solution_1684_Count_the_Number_of_Consistent_Strings {
    public int countConsistentStrings(String allowed, String[] words) {
        String[] allowedArray = allowed.split("");
        int result = 0;
        for (String word : words) {
            String tmp = word;
            for (String alld : allowedArray) {
                tmp = tmp.replace(alld, "");
                if (tmp.length() == 0) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    // others code
    public int countConsistentStrings2(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}