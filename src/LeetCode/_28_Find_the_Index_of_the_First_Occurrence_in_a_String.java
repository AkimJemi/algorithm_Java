package LeetCode;

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("sadbutsad", "sad"));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}