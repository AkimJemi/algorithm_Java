package LeetCode;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        String test = "";
//        System.out.println(Arrays.toString(test.split(" ")));
//        Map<Character, Integer> map = new HashMap<>();
//        System.out.println(map.get('c'));
        Integer test = 1;
        int te = 2;
        System.out.println(test.equals(te));
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