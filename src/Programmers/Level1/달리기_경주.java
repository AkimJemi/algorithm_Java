package Programmers.Level1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 달리기_경주 {
    public static void main(String[] args) {
        String[] players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = new String[]{"kai", "kai", "mine", "mine", "mine"};
        System.out.println(Arrays.toString(new Solution_달리기_경주().solution(players, callings)));
    }
}

class Solution_달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Long> map = Arrays.stream(callings).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        List<String> list = Arrays.asList(players);
        Map<String, Long> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < players.length; i++) {
            int rankPoint = players.length - i;
            if (map.containsKey(players[i])) {
                rankPoint = rankPoint + (int) map.get(players[i]).longValue();
            }
//            resultMap.put((long) rankPoint, players[i]);
            resultMap.put(players[i], (long) rankPoint);
//            if (!resultMap.containsKey(rankPoint)) {
//            } else {
//
//            }
        }
        System.out.println(resultMap);
        return null;
    }
//    public String[] solution(String[] players, String[] callings) {
//        List<String> playerList = Arrays.asList(players);
//        Map<String, Integer> map = IntStream.range(0, players.length).mapToObj(operand -> Map.entry(players[operand], (int) playerList.indexOf(players[operand]))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(map);
//        for (String calling : callings) {
//            int targetIndex = playerList.indexOf(calling);
//            String fromStr = playerList.get(targetIndex);
//            String toStr = playerList.get(targetIndex - 1);
//            playerList.set(targetIndex, toStr);
//            playerList.set(targetIndex - 1, fromStr);
//        }
//        return playerList.toArray(String[]::new);
//    }
//    public String[] solution(String[] players, String[] callings) {
//        List<String> playerList = Arrays.asList(players);
//        for (String calling : callings) {
//            int targetIndex = playerList.indexOf(calling);
//            String fromStr = playerList.get(targetIndex);
//            String toStr = playerList.get(targetIndex - 1);
//            playerList.set(targetIndex, toStr);
//            playerList.set(targetIndex - 1, fromStr);
//        }
//        return playerList.toArray(String[]::new);
//    }
}
