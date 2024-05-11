package Programmers.Level1;

import java.util.*;
import java.util.stream.Collectors;

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

class Solution신고_결과_받기1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}


class Solution신고_결과_받기2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String, Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String, Integer> idIdx = new HashMap<>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;
        for (String name : id_list) {
            idIdx.put(name, idx++);
            users.add(new User(name));
        }
        for (String re : report) {
            String[] str = re.split(" ");
            users.get(idIdx.get(str[0])).reportList.add(str[1]);
            users.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }
        for (User user : users) {
            if (user.reportedList.size() >= k)
                suspendedList.put(user.name, 1);
        }
        for (User user : users) {
            for (String nameReport : user.reportList) {
                if (suspendedList.get(nameReport) != null) {
                    answer[idIdx.get(user.name)]++;
                }
            }
        }
        return answer;
    }
}
class User {
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name) {
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}

class Solution신고_결과_받기3 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // key: 신고당한놈, value: 몇명한테 당했는지
        Map<String, Set<String>> map = new HashMap<>();
        for (String rep : report) {
            String[] arr = rep.split(" ");
            Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
            set.add(arr[0]);
            map.put(arr[1], set);
        }
        // key: 알림받을 놈, value: 몇번 알림받을지
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String id : id_list) {
            countMap.put(id, 0);
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) { // 정지당할놈
                for (String value : entry.getValue()) {
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                }
            }
        }
        return countMap.values().stream().mapToInt(Integer::intValue).toArray();
    }
}

class Solution신고_결과_받기4 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idIndex = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
            reportMap.put(id_list[i], new ArrayList<>());
        }
        for (String reported : report) {
            String[] temp = reported.split(" ");
            if (!reportMap.get(temp[1]).contains(temp[0])) {
                reportMap.get(temp[1]).add(temp[0]);
            }
        }
        for (String id : reportMap.keySet()) {
            if (k <= reportMap.get(id).size()) {
                for (String reporter : reportMap.get(id)) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }
        return answer;
    }
}