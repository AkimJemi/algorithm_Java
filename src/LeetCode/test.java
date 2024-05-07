package LeetCode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        String a = "1234";
        String b = "12345";
        System.out.println(b.compareTo(a));


//        List<String> resultList = List.of("1", "2", "3", "4", "3").stream()
//                .filter(old -> List.of("5", "2", "3", "4").stream()
//                        .anyMatch(Predicate.isEqual(old)))
//                .collect(Collectors.toList());
//        String test = "";
//        System.out.println(Arrays.toString(test.split(" ")));
//        Map<Character, Integer> map = new HashMap<>();
//        System.out.println(map.get('c'));
//        int[] phone = new int[]{2, 3, 5};
//        for (int i = 0; i < phone.length; i++) {
//            System.out.println(phone[i]); // 0 1 2
//        }

//        Integer test = 1;
//        int te = 2;
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(1);
//        priorityQueue.add(2);
//        priorityQueue.add(4);
//        priorityQueue.add(3);
//        priorityQueue.add(2);
//
//        System.out.println(priorityQueue);
//        System.out.println(priorityQueue.peek());
//        System.out.println(priorityQueue);
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue);

//        System.out.println((int) Double.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE + 1);
//        System.out.println(Integer.MAX_VALUE * 2 + 2);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Short.MAX_VALUE);
//        System.out.println(Byte.MAX_VALUE);
//        void001();
//        void002();
//        int x = 10;
//        int y = 15;
//        void003(x, y);
//        System.out.println((int) 'a');
//                    int count = (int) IntStream.rangeClosed(1, a).filter(b -> a % b == 0).count();
    }

    private static void void003(int x, int y) {
        x += 5;
        y += 10;
        System.out.println(x);
        System.out.println(y);
    }

    private static void void002() {
        String test1 = "test1";
        String test2 = test1 = "test2";
        System.out.println(test1);
        System.out.println(test2);
    }


    private static void void001() {
        List<String> test1 = new ArrayList<>();
        test1.add("a");
        test1.add("a");
        test1.add("b");
        test1.add("a");
        test1.add("c");
        test1.add("c");
        List<String> test2 = new ArrayList<>();
        test2.add("a");
        test2.add("a");
        test2.add("b");
        System.out.println(test1);
        System.out.println(test1.retainAll(test2));
        System.out.println(test1);

    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String[] mergeArray = new String[cards1.length + cards2.length];
        System.arraycopy(cards1, 0, mergeArray, 0, cards1.length);
        System.arraycopy(cards2, 0, mergeArray, cards1.length, cards2.length);
        Arrays.sort(mergeArray);
        Arrays.sort(goal);
        System.out.println(Arrays.toString(mergeArray));
        System.out.println(Arrays.equals(mergeArray, goal));
        return "";
    }
}
//    public int solution(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char target = s.charAt(i);
//            if (map.isEmpty()) {
//                map.put(target, map.getOrDefault(target, 0) + 1);
//                if (i == s.length() - 1) {
//                    count++;
//                }
//                continue;
//            }
//            map.put(target, map.getOrDefault(target, 0) + 1);
//            int targetCount = map.getOrDefault(target, 0);
//            Optional<Map.Entry<Character, Integer>> optional = map.entrySet().stream().filter(a -> !a.getKey().equals(target)).filter(a -> a.getValue() == targetCount).findFirst();
//            if (!optional.isPresent()) {
//                if (i == s.length() - 1) {
//                    count++;
//                }
//            } else {
//                map = new HashMap<>();
//                count++;
//            }

//package Programmers.Level1;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class 명예의_전당_1 {
//    public static void main(String[] args) {
//        int[] intArray = new int[]{};
//        String[] strArray = new String[]{};
//        System.out.println(Arrays.toString(new Solution명예의_전당_1().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
//    }
//}
//
//class Solution명예의_전당_1 {
//    public int[] solution(int k, int[] score) {
//        int[] array = new int[score.length];
//        int[] result = new int[score.length];
//        int arrayMinIndex = 0;
//        int arrayMinVal = score[arrayMinIndex];
//        for (int i = 0; i < score.length; i++) {
//            if (i < k) {
//                if (arrayMinVal < score[i]) {
//                    result[i] = arrayMinVal;
//                } else {
//                    arrayMinIndex = i;
//                    arrayMinVal = score[arrayMinIndex];
//                    result[i] = score[i];
//                }
//                array[i] = score[i];
//            } else {
//                if (arrayMinVal < score[i]) {
//                    arrayMinIndex = i;
//                    arrayMinVal = score[arrayMinIndex];
//                    array[arrayMinIndex] = arrayMinVal;
//                    result[i] = arrayMinVal;
//                } else {
//                    arrayMinIndex = i;
//                    arrayMinVal = score[arrayMinIndex];
//                    result[i] = score[i];
//                }
//                result[i] = arrayMinVal;
//            }
//        }
//        return result;
//    }
//}
///*
// *Someone else's code to study
// * */