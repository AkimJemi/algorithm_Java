package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _401_Binary_Watch {
    public static void main(String[] args) {
        System.out.println(new Solution_401_Binary_Watch().readBinaryWatch(2));
        System.out.println(new Solution_401_Binary_Watch().readBinaryWatch(9));
    }
}

class Solution_401_Binary_Watch {
    List<Integer> hours = List.of(1, 2, 4, 8);
    List<Integer> minutes = List.of(1, 2, 4, 8, 16, 32);

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn >= 9) {
            return new ArrayList<>();
        }
        List<List<Integer>> hoursList = backtracking(new ArrayList<>(), new ArrayList<>(), hours, 0);
        List<List<Integer>> minutesList = backtracking(new ArrayList<>(), new ArrayList<>(), minutes, 0);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < turnedOn + 1; i++) {
            int loop = i;
            List<Integer> tmpHoursList = hoursList.stream().filter(a -> a.size() == turnedOn - loop).map(a -> a.stream().mapToInt(Integer::intValue).sum()).filter(a -> a < 12).collect(Collectors.toList());
            List<Integer> tmpMinutesList = minutesList.stream().filter(a -> a.size() == loop).map(a -> a.stream().mapToInt(Integer::intValue).sum()).filter(a -> a < 60).collect(Collectors.toList());
            for (Integer hour : tmpHoursList) {
                for (Integer min : tmpMinutesList) {
                    result.add(hour + ":" + (min < 10 ? "0" + min : min));
                }
            }
        }
        return result.stream().sorted((a, b) -> Integer.valueOf(a.split(":")[0] + a.split(":")[1]) - Integer.valueOf(b.split(":")[0] + b.split(":")[1])).collect(Collectors.toList());
    }

    private List<List<Integer>> backtracking(List<List<Integer>> list, List<Integer> tmp, List<Integer> targetList, int start) {
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < targetList.size(); i++) {
            tmp.add(targetList.get(i));
            backtracking(list, tmp, targetList, i + 1);
            tmp.remove(tmp.size() - 1);
        }
        return list;
    }

    // others code
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> res = new ArrayList<String>();
        if (turnedOn >= 9) {
            return res;
        }
        helper(res, turnedOn, 0, 0, 0, new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32});
        return res;
    }


    private void helper(List<String> res, int lights, int hours, int mins, int index, int[] leds) {
        if (lights == 0) {
            StringBuilder str = new StringBuilder();
            str.append(hours);
            str.append(":");
            if (mins < 10) {
                str.append("0");
            }
            str.append(mins);
            res.add(str.toString());
        } else {
            for (int i = index; i < 10; i++) {
                if (i < 4) {
                    if (hours + leds[i] < 12) {
                        hours += leds[i];
                        helper(res, lights - 1, hours, mins, i + 1, leds);
                        hours -= leds[i];
                    }
                } else {
                    if (mins + leds[i] < 60) {
                        mins += leds[i];
                        helper(res, lights - 1, hours, mins, i + 1, leds);
                        mins -= leds[i];
                    }
                }
            }
        }
    }
}