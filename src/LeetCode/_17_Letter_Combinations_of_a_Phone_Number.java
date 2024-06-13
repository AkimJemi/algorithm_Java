package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class _17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("02"));
    }
}

class Solution17 {
    Map<String, List<String>> mapStringTransfer(String key, String value) {
        Map<String, List<String>> tmp = new HashMap<>();
        tmp.put(key, Arrays.stream(value.split("")).collect(Collectors.toList()));
        return tmp;
    }

    Map<String, List<String>> map = new HashMap<>() {
        {
            putAll(mapStringTransfer("2", "abc"));
            putAll(mapStringTransfer("3", "def"));
            putAll(mapStringTransfer("4", "ghi"));
            putAll(mapStringTransfer("5", "jkl"));
            putAll(mapStringTransfer("6", "mno"));
            putAll(mapStringTransfer("7", "pqrs"));
            putAll(mapStringTransfer("8", "tuv"));
            putAll(mapStringTransfer("9", "wxyz"));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<List<String>> strList = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        for (String str : digits.split("")) {
            if (map.containsKey(str)) {
                strList.add(map.get(str));
            }
        }
        if (strList.size() > 0) {
            for (String str1 : strList.get(0)) {
                if (strList.size() > 1) {
                    for (String str2 : strList.get(1)) {
                        if (strList.size() > 2) {
                            for (String str3 : strList.get(2)) {
                                if (strList.size() > 3) {
                                    for (String str4 : strList.get(3))
                                        addList(resList, str1 + str2 + str3 + str4);
                                }
                                if (strList.size() == 3)
                                    addList(resList, str1 + str2 + str3);
                            }
                        }
                        if (strList.size() == 2)
                            addList(resList, str1 + str2);
                    }
                }
                if (strList.size() == 1)
                    addList(resList, str1);
            }
        }
        return resList.stream().sorted().collect(Collectors.toList());
    }

    private void addList(List<String> resList, String... strArray) {
        resList.add(Arrays.stream(strArray).collect(Collectors.joining()));
    }
}
