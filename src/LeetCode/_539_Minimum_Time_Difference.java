package LeetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _539_Minimum_Time_Difference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("00:00", "23:59", "00:00"));
        System.out.println(new Solution_539_Minimum_Time_Difference().findMinDifference(list));
    }
}

class Solution_539_Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int timeDiff1 = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int a = getMinuteDiff(timePoints.get(i));
            int b = getMinuteDiff(timePoints.get(i + 1));
            if ((b - a) < timeDiff1) {
                timeDiff1 = b - a;
            }
        }
        String[] array = timePoints.get(0).split(":");
        int timeDiff2 = getMinuteDiff((Integer.valueOf(array[0]) + 24) + ":" + array[1]) - getMinuteDiff(timePoints.get(timePoints.size() - 1));
        return Math.min(timeDiff1, timeDiff2);
    }

    public int getMinuteDiff(String a) {
        String[] time = a.split(":");
        return Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
    }
//    public int findMinDifference(List<String> timePoints) {
//        Collections.sort(timePoints);
//        String fir = timePoints.get(0);
//        String sec = timePoints.get(1);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//        LocalTime time1 = LocalTime.parse(fir, formatter);
//        LocalTime time2 = LocalTime.parse(sec, formatter);
//
//        String thr = timePoints.get(timePoints.size() - 1);
//        String bFir = fir.compareTo(thr) > 0 ? fir : thr;
//        String bSec = fir.compareTo(thr) < 0 ? fir : thr;
//
//        LocalTime startTime = LocalTime.parse(bFir, formatter);
//        LocalTime endTime = LocalTime.parse(bSec, formatter);
//
//        LocalDateTime startDateTime = LocalDateTime.now().with(startTime);
//        LocalDateTime endDateTime = LocalDateTime.now().with(endTime);
//
//        if (endDateTime.isBefore(startDateTime)) {
//            endDateTime = endDateTime.plusDays(1);
//        }
//        long minutesDifference1 = Duration.between(time1, time2).toMinutes();
//        long minutesDifference2 = Duration.between(startDateTime, endDateTime).toMinutes();
//        return (int) (minutesDifference1 > minutesDifference2 ? minutesDifference2 : minutesDifference1);
//    }

    // others code
    public int findMinDifference1(List<String> timePoints) {
        boolean[] time = new boolean[1440];
        int first = 1440;
        int last = 0;
        for (int i = 0; i < timePoints.size(); i++) {
            String tmp = timePoints.get(i);
            int idx = ((tmp.charAt(0) - '0') * 10 + (tmp.charAt(1) - '0')) * 60 + (tmp.charAt(3) - '0') * 10 + (tmp.charAt(4) - '0');
            if (time[idx]) {
                return 0;
            }
            time[idx] = true;
            first = Math.min(first, idx);
            last = Math.max(last, idx);
        }

        int ans = first + 1440 - last;
        int prev = first;
        for (int i = first + 1; i < 1440; i++) {
            if (time[i]) {
                ans = Math.min(ans, i - prev);
                prev = i;
            }
        }
        return ans;
    }
}