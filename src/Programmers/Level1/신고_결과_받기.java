package Programmers.Level1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(new Solution신고_결과_받기().solution(id_list, report, k)));
    }
}

class Solution신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reported = report[i].split(" ")[1];
            if (!map.getOrDefault(reported, new ArrayList<>()).contains(reporter)) {
                List<String> list = map.getOrDefault(reported, new ArrayList<>());
                list.add(reporter);
                map.put(reported, list);
            }
        }
        Map<String, Integer> idListMap = new LinkedHashMap<>();
        for (int index = 0; index < id_list.length; index++) {
            idListMap.put(id_list[index], 0);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String str : entry.getValue()) {
                    idListMap.replace(str, idListMap.get(str) + 1);
                }
            }
        }
        return idListMap.entrySet().stream().mapToInt(Map.Entry::getValue).toArray();
    }
}

/*
 *Someone else's code to study
 * */