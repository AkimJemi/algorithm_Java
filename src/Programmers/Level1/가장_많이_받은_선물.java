package Programmers.Level1;

import java.util.*;
import java.util.stream.Collectors;

public class 가장_많이_받은_선물 {
    public static void main(String[] args) {
        String[] frineds = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
//        String[] frineds = new String[]{"muzi", "ryan", "frodo", "neo"};
//        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(new Solution().solution(frineds, gifts));
    }

    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            Map<String, Long> givenCount = Arrays.stream(gifts).map(a -> a.split(" ")[0]).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
            Map<String, Long> takenCount = Arrays.stream(gifts).map(a -> a.split(" ")[1]).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
            Map<String, Long> resultMap = new HashMap<>();
            Map<String, Long> giveAndTakeMap = Arrays.stream(gifts).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
            for (int i = 0; i < friends.length; i++) {
                for (int j = i + 1; j < friends.length; j++) {
                    String firFriend = friends[i];
                    String secFriend = friends[j];
                    String checkGiftExchage1 = firFriend + " " + secFriend;
                    String checkGiftExchage2 = secFriend + " " + firFriend;
                    if (!firFriend.equals(secFriend)) {
                        if (!giveAndTakeMap.containsKey(checkGiftExchage1) && !giveAndTakeMap.containsKey(checkGiftExchage2)) {
                            compareMethod(givenCount, takenCount, resultMap, firFriend, secFriend);
                        } else {
                            if (giveAndTakeMap.getOrDefault(checkGiftExchage1, 0L) > giveAndTakeMap.getOrDefault(checkGiftExchage2, 0L)) {
                                resultMap.put(firFriend, resultMap.getOrDefault(firFriend, 0L) + 1);
                            } else if (giveAndTakeMap.getOrDefault(checkGiftExchage1, 0L) < giveAndTakeMap.getOrDefault(checkGiftExchage2, 0L)) {
                                resultMap.put(secFriend, resultMap.getOrDefault(secFriend, 0L) + 1);
                            } else {
                                compareMethod(givenCount, takenCount, resultMap, firFriend, secFriend);
                            }
                        }
                    }
                }
            }
            Optional<Map.Entry<String, Long>> optional = resultMap.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
            if (optional.isPresent()) {
                return (int) optional.get().getValue().longValue();
            }
            return 0;
        }

        void compareMethod(Map<String, Long> givenCount, Map<String, Long> takenCount, Map<String, Long> resultMap, String firFriend, String secFriend) {
            long firstPersonGiftPoint = givenCount.getOrDefault(firFriend, 0L) - takenCount.getOrDefault(firFriend, 0L);
            long secondPersonGiftPoint = givenCount.getOrDefault(secFriend, 0L) - takenCount.getOrDefault(secFriend, 0L);
            if (firstPersonGiftPoint > secondPersonGiftPoint) {
                resultMap.put(firFriend, resultMap.getOrDefault(firFriend, 0L) + 1);
            } else if (firstPersonGiftPoint < secondPersonGiftPoint) {
                resultMap.put(secFriend, resultMap.getOrDefault(secFriend, 0L) + 1);
            }
        }
    }
}
