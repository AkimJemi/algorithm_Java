package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class _409_Longest_Palindrome {
    public static void main(String[] args) {
//        System.out.println(new Solution409().longestPalindrome("abccccdd"));
//        System.out.println(new Solution409().longestPalindrome("a"));
//        System.out.println(new Solution409().longestPalindrome("ab"));
//        System.out.println(new Solution409().longestPalindrome("a"));
//        System.out.println(new Solution409().longestPalindrome("abbb"));
//        System.out.println(new Solution409().longestPalindrome("abbbabbbaba"));
        // 983
        System.out.println(new Solution409().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}

class Solution409 {
    public int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        char before = charArray[0];
        int length = 0;
        for (int i = 0; i < charArray.length; i++) {
            char targetChar = charArray[i];
            if (targetChar != before) {
                String targetStr = String.valueOf(before).repeat(length);
                map.put(targetStr, map.getOrDefault(targetStr, 0) + 1);
                length = 0;
            }
            if (i == charArray.length - 1) {
                String targetStr = String.valueOf(targetChar).repeat(++length);
                map.put(targetStr, map.getOrDefault(targetStr, 0) + 1);
            }
            length++;
            before = targetChar;
        }
        int evenSum = 0;
        int oddSum = 0;
        int oddMax = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int mapKeyLength = entry.getKey().length();
            int mapValue = entry.getValue();
            int targetNum = mapValue * mapKeyLength;
            if (mapKeyLength % 2 == 0) {
                evenSum += targetNum;
            } else if (mapValue % 2 == 0) {
                oddSum += targetNum;
            } else {
                if (targetNum > oddMax) {
                    oddMax = targetNum;
                }
            }
        }
        return evenSum + oddSum + oddMax;
    }

//        List<Integer> countList = Arrays.stream(intArray).filter(a -> a != 0).boxed().collect(Collectors.toList());
//        System.out.println(countList);
//        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//        Optional<Map.Entry<String, Long>> maxOddOptional = collect.entrySet().stream().filter(a -> a.getValue() % 2 != 0).max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//        return (int) (maxOddOptional.isPresent() ? maxOddOptional.get().getValue() : 0) + collect.entrySet().stream().filter(a -> a.getValue() % 2 == 0).map(Map.Entry::getValue).mapToInt(Long::intValue).sum();
//    public int longestPalindrome(String s) {
//        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//        int evenSum = collect.entrySet().stream().filter(a -> a.getValue() % 2 == 0).map(Map.Entry::getValue).mapToInt(Long::intValue).sum();
//        List<Long> listOdd = collect.entrySet().stream().map(Map.Entry::getValue).filter(a -> a % 2 != 0).collect(Collectors.toList());
//        if (listOdd.size() % 2 == 0) {
//            return listOdd.stream().mapToInt(Long::intValue).sum() + evenSum;
//        } else {
//            listOdd.remove(listOdd.stream().min((o1, o2) -> o1.compareTo(o2)));
//            return listOdd.stream().mapToInt(Long::intValue).sum() + evenSum;
//        }
//    }
}