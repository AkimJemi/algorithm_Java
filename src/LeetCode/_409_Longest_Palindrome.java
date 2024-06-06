package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class _409_Longest_Palindrome {
    public static void main(String[] args) {
        System.out.println(new Solution409().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}

class Solution409 {
    public int longestPalindrome(String s) {
        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        Optional<Map.Entry<String, Long>> maxOddOptional = collect.entrySet().stream().filter(a -> a.getValue() % 2 != 0).max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        return (int) (maxOddOptional.isPresent() ? maxOddOptional.get().getValue() : 0) + collect.entrySet().stream().filter(a -> a.getValue() % 2 == 0).map(Map.Entry::getValue).mapToInt(Long::intValue).sum();
    }
}