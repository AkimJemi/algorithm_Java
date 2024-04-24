package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class 기타 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("b");
        list1.remove("b");
        list1.remove("b");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("a");
        System.out.println(list1);

    }
//        Map<String, Long> map = Arrays.stream(callings).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//        List<String> list = Arrays.asList(players);
//        System.out.println(list);
//        Map<String, Integer> map2 = IntStream.range(0, players.length).mapToObj(operand -> Map.entry(players[operand], (int) list.indexOf(players[operand]))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(map2);
    //        Map<String, Long> resultMap = new HashMap<>();
//        for (int i = 0; i < players.length; i++) {
//            int rankPoint = players.length - i;
////            int rankPoint = 0;
//            if (map.containsKey(players[i])) {
//                rankPoint = rankPoint + (int) map.get(players[i]).longValue();
//            }
//            resultMap.put(players[i], (long) rankPoint);
//        }
//        System.out.println(resultMap);
}
