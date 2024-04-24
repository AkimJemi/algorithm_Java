package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _76_Minimum_Window_Substring {
    public static void main(String[] args) {
//        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(new Solution76().minWindow("a", "a"));
//        System.out.println(new Solution76().minWindow("a", "aa"));
//        System.out.println(new Solution76().minWindow("bbaa", "aba"));
//        System.out.println(new Solution76().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
//        System.out.println(new Solution76().minWindow("a", "b"));
//        System.out.println(new Solution76().minWindow("caae", "cae"));
        System.out.println(new Solution76().minWindow("vlssjudabstgkzxzcpglfgogiwkowyvulnmujpwkjrqvsnwvdcikjwqtsdhrdclorxkaoikazbvuqspvwxhhvybndieglrucqgfhophpsejlwagtzoauobkrmqzzivdybifpyoestqdrqkmqapkoquhenidvdhvepdvprbimrneizsyzhkpyhyeugirjropgrmyloixfvdnvwnwdamdhmidtsuejiwrcipnwzmevqrsohqrhexqrhtkzpqkzobbxtqvsdzpvtjjcacjezbxiwhjlatmoxonqejkhkcednnfnqqurrrcnbladfntcdhuhserciviwlnldgfwxzynakpfpcythfnrxtkcchkaszlvftsfsqsuajbrozkvhzmgtwixesxwukuzdoexgytjiuawuntbmghhcseimbhgobgrrmrxnkgxfhvbwoeiulqzdwhsaoyorghityggjmdqvyttoxclkukqqtiqkggbnomimuqxitpgtizjfduqxggqaoimwppjdbrrvjpgeemxpljupdmokseminyfenqjrkaotruyygxnsgjjmwxwqckzrigxxygoigdcaxcyeznyiwhuueslicmbmuyjseybnbfnahleiaeqwlmrseeaiqcukaecfefsfmhhtumeuqwqejjwpnyyfaupdyukebejoltjffnzxmrdvdzksykyafpdflnknrvbeomlvckvoeyjjyvbyizypreucrgplcsrsfdohpjvvh", "gehdgflhgaykx"));
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        String result = null;
        int strLength = t.length();
        String minResult = null;
        while (result == null || strLength <= s.length()) {
            result = minWindowMethod(s, t, strLength);
            if ((minResult == null || minResult.length() > result.length()) && result.length() != 0) {
                minResult = result;
            }
            strLength++;
        }
        return minResult != null ? minResult : "";
    }

    private String minWindowMethod(String s, String t, int strLength) {
        List<String> targetList = Arrays.stream(t.split("")).collect(Collectors.toList());
        String[] strArray = s.split("");
        List<Map.Entry<Integer, String>> entryList = IntStream
                .range(0, strArray.length)
                .boxed()
                .collect(Collectors.toMap(a -> a, b -> strArray[b]))
                .entrySet()
                .stream()
                .filter(a -> targetList.contains(a.getValue()))
                .collect(Collectors.toList());
        int start = 0;
        int end = 0;
        int minimumStart = 0;
        int minimumEnd = 0;
        Integer minimun = null;
        for (int i = 0; i <= entryList.size() - strLength; i++) {
            List<Map.Entry<Integer, String>> subEntryList = entryList.subList(i, i + strLength);
            List<String> tmpList = new ArrayList<>(targetList);
            for (Map.Entry<Integer, String> entry : subEntryList) {
                tmpList.remove(entry.getValue());
            }
            if (tmpList.isEmpty()) {
                start = subEntryList.get(0).getKey();
                end = subEntryList.get(strLength - 1).getKey() + 1;
                if (minimun == null || minimun > end - start) {
                    minimumStart = start;
                    minimumEnd = end;
                    minimun = end - start;
                }
            }
        }
        return s.substring(minimumStart, minimumEnd);
    }
}