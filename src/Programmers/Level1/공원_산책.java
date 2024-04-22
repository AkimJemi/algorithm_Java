package Programmers.Level1;

import java.util.Arrays;

public class 공원_산책 {
    public static void main(String[] args) {
        String[] park = new String[]{"SOO", "OOO", "OOO"};
        String[] routes = new String[]{"E 2", "S 2", "W 1"};
        System.out.println(new Solution_공원_산책().solution(park, routes));

    }
}

class Solution_공원_산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        for (String route : routes) {
            String direction = route.split(" ")[0];
            String movement = route.split(" ")[1];

        }


        return answer;
    }
}