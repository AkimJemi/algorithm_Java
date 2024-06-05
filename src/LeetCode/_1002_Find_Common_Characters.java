package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1002_Find_Common_Characters {
    public static void main(String[] args) {
        System.out.println(new Solution1002().commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(new Solution1002().commonChars(new String[]{"cool", "lock", "cook"}));
    }


}

class Solution1002 {
    public List<String> commonChars(String[] words) {
        List<String> baseList = Arrays.stream(words[0].split("")).collect(Collectors.toList());
        for (int i = 1; i < words.length; i++) {
            String targetStr = words[i];
            List<String> copyList = new ArrayList<>(baseList);
            for (String str : copyList) {
                if (targetStr.contains(str)) {
                    targetStr = targetStr.replaceFirst(str, "");
                    continue;
                }
                baseList.remove(str);
            }
        }
        return baseList;
    }
}