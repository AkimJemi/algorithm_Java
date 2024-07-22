package LeetCode;

public class _242_Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(new Solution242().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution242().isAnagram("rat", "car"));

    }
}

class Solution242 {
    // mycode
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        if (sLength != t.length()) return false;

        for (Character cha : s.toCharArray()) {
            t = t.replaceFirst(String.valueOf(cha), "");
            sLength--;
            if (t.length() != sLength) {
                return false;
            }
        }
        return true;
    }

    // other code
    public boolean isAnagram2(String s, String t) {
        int[] count = new int[26];
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}