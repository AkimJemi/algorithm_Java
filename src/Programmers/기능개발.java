package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));

    }
}

class Solution3 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int left = 100 - progress;
            int day = 0;
            while (left > 0) {
                left = left - speed;
                day++;
            }
            days[i] = day;
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            count++;
            if (i == days.length - 1) {
                list.add(count);
                break;
            }
            if (days[i + 1] > days[i]) {
                list.add(count);
                count = 0;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}