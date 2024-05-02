package Programmers.Level1;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/172928?language=java
*/
public class 공원_산책 {
    public static void main(String[] args) {
//        test();
        String[] park = new String[]{"OSOOO", "XOOOO", "OXOOO", "OOOXX"};
        String[] routes = new String[]{"E 2", "S 3", "W 1", "E 1", "N 3"};
        System.out.println(Arrays.equals(new Solution_공원_산책().solution(park, routes), new int[]{0, 3}));
        park = new String[]{"OOOOOOS", "OOOOOOO", "OOOOOOO", "OOOOOOO"};
        routes = new String[]{"E 1", "W 7", "W 6", "E 6", "S 4", "S 3", "N 4", "N 3"};
        System.out.println(Arrays.equals(new Solution_공원_산책().solution(park, routes), new int[]{0, 6}));
    }

    private static void test() {
        String[] park = new String[]{"SOO", "OOO", "OOO"};
        String[] routes = new String[]{"E 2", "S 2", "W 1"};
        System.out.println(Arrays.equals(new Solution_공원_산책().solution(park, routes), new int[]{2, 1}));
        park = new String[]{"SOO", "OXX", "OOO"};
        routes = new String[]{"E 2", "S 2", "W 1"};
        System.out.println(Arrays.equals(new Solution_공원_산책().solution(park, routes), new int[]{0, 1}));
        park = new String[]{"OSO", "OOO", "OXO", "OOO"};
        routes = new String[]{"E 2", "S 3", "W 1"};
        System.out.println(Arrays.equals(new Solution_공원_산책().solution(park, routes), new int[]{0, 0}));
    }
}

class Solution_공원_산책 {
    public int[] solution(String[] park, String[] routes) {
        int targetX = 0;
        int targetY = 0;
        int parkLength = park[0].length();
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                targetY = i;
                targetX = park[i].indexOf("S");
                break;
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int movement = Integer.valueOf(routes[i].split(" ")[1]);
            if (direction.equals("E")) {
                int compareLength = targetX + movement;
                if (compareLength + 1 > parkLength) {
                    continue;
                }
                String east = park[targetY].substring(targetX + 1, compareLength + 1);
                if (east.isEmpty() || east.contains("X")) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                park[targetY] = park[targetY].substring(0, compareLength) + "S" + park[targetY].substring(compareLength + 1);
                targetX = compareLength;
            } else if (direction.equals("W")) {
                int compareLength = targetX - movement;
                if (compareLength < 0) {
                    continue;
                }
                String west = park[targetY].substring(compareLength, targetX);
                if (west.isEmpty() || west.contains("X")) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                park[targetY] = park[targetY].substring(0, compareLength) + "S" + park[targetY].substring(compareLength + 1);
                targetX = compareLength;
            } else if (direction.equals("S")) {
                int compareLength = targetY + movement;
                if (compareLength + 1 > park.length) {
                    continue;
                }
                int lambdaInt = targetX;
                String south = Arrays.stream(park).map(a -> String.valueOf(a.charAt(lambdaInt))).collect(Collectors.joining()).substring(targetY + 1, compareLength + 1);
                if (south.isEmpty() || south.contains("X")) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                targetY = compareLength;
                park[targetY] = park[targetY].substring(0, targetX) + "S" + park[targetY].substring(targetX + 1);
            } else if (direction.equals("N")) {
                int compareLength = targetY - movement;
                if (compareLength < 0) {
                    continue;
                }
                int lambdaInt = targetX;
                String north = Arrays.stream(park).map(a -> String.valueOf(a.charAt(lambdaInt))).collect(Collectors.joining()).substring(compareLength, targetY);
                if (north.isEmpty() || north.contains("X")) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                targetY = compareLength;
                park[targetY] = park[targetY].substring(0, targetX) + "S" + park[targetY].substring(targetX + 1);
            }
        }
        return new int[]{targetY, targetX};
    }
}