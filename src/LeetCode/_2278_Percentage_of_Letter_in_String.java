package LeetCode;

public class _2278_Percentage_of_Letter_in_String {
    public static void main(String[] args) {
        System.out.println(new Solution_2278_Percentage_of_Letter_in_String().percentageLetter("foobar", 'o'));
        System.out.println(new Solution_2278_Percentage_of_Letter_in_String().percentageLetter("foobar", 'o'));
    }
}

class Solution_2278_Percentage_of_Letter_in_String {
    public int percentageLetter(String s, char letter) {
        return ((int) s.chars().filter(a -> a == letter).count() * 100) / s.length();
    }
}
