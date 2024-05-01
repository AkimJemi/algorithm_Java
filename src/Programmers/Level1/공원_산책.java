package Programmers.Level1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 공원_산책 {
    public static void main(String[] args) {
        String[] park = new String[]{"SOO","OXX","OOO"};
        String[] routes = new String[]{"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(new Solution_공원_산책().solution(park, routes)));

    }
}

class Solution_공원_산책 {
    public int[] solution(String[] park, String[] routes) {
        int targetX = 0;
        int targetY = 0;
        String target = "";
        for (int i = 0; i < park.length; i++) {
            target = park[i];
            if (target.contains("S")) {
                targetY = i;
                targetX = target.indexOf("S");
                break;
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int movement = Integer.valueOf(routes[i].split(" ")[1]);
            targetY = i;
            targetX = target.indexOf("S");
            if (direction.equals("E")) {
                String east = target.substring(targetX + 1, target.length());
                if (east.isEmpty() || east.contains("X") || movement > east.length()) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                park[targetY] = park[targetY].substring(0, targetX + movement) + "S" + park[targetY].substring(targetX + movement + 1);
                target = park[i];
                targetX = targetX + movement;
            } else if (direction.equals("W")) {
                String west = target.substring(0, targetX - 1);
                if (west.isEmpty() || west.contains("X") || movement > west.length()) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                park[targetY] = park[targetY].substring(0, targetX - movement) + "S" + park[targetY].substring(targetX - movement + 1);
                target = park[i];
                targetX = targetX - movement;
            } else if (direction.equals("S")) {
                int lambdaInt = targetY;
                String south = Arrays.stream(park).map(a -> String.valueOf(a.charAt(lambdaInt))).collect(Collectors.joining());
                if (south.isEmpty() || south.contains("X") || movement > south.length()) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                targetY = targetY + movement;
                park[targetY] = park[targetY].substring(0, targetX) + "S" + park[targetY].substring(targetX + 1);
            } else if (direction.equals("N")) {
                int lambdaInt = targetY;
                String north = Arrays.stream(park).map(a -> String.valueOf(a.charAt(lambdaInt))).collect(Collectors.joining());
                if (north.isEmpty() || north.contains("X") || movement > north.length()) {
                    continue;
                }
                park[targetY] = park[targetY].replace("S", "O");
                targetY = targetY + movement;
                park[targetY] = park[targetY].substring(0, targetX) + "S" + park[targetY].substring(targetX + 1);
            }
        }
        System.out.println(Arrays.toString(park));
        return new int[]{targetY, targetX};
    }

}