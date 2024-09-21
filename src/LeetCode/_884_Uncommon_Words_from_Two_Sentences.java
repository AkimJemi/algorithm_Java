package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _884_Uncommon_Words_from_Two_Sentences {
    public static void main(String[] args) {
        System.out.println(new Solution_884_Uncommon_Words_from_Two_Sentences().uncommonFromSentences("this apple is sweet", "this apple is sour"));
        System.out.println(new Solution_884_Uncommon_Words_from_Two_Sentences().uncommonFromSentences("apple apple", "banana"));
    }
}

class Solution_884_Uncommon_Words_from_Two_Sentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        return Arrays.stream((s1 + " " + s2).split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(a -> a.getValue() == 1).map(a -> a.getKey()).toArray(String[]::new);
    }

    // other's code
    public String[] uncommonFromSentences2(String s1, String s2) {
        HashSet<String> uncommon = new HashSet<>();
        HashSet<String> common = new HashSet<>();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        for (String e1 : arr1) {
            if (common.contains(e1)) {
                continue;
            } else if (uncommon.contains(e1)) {
                uncommon.remove(e1);
                common.add(e1);
            } else {
                uncommon.add(e1);
            }
        }

        for (String e1 : arr2) {
            if (common.contains(e1)) {
                continue;
            } else if (uncommon.contains(e1)) {
                uncommon.remove(e1);
                common.add(e1);
            } else {
                uncommon.add(e1);
            }
        }
        String[] res = uncommon.toArray(new String[uncommon.size()]);
        return res;
    }
}