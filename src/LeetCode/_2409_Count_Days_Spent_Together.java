package LeetCode;

import java.util.Calendar;

public class _2409_Count_Days_Spent_Together {
    public static void main(String[] args) {
        System.out.println(new Solution2409().countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(new Solution2409().countDaysTogether("10-01", "10-31", "11-01", "12-31"));
        System.out.println(new Solution2409().countDaysTogether("01-20", "04-18", "01-01", "08-30"));
    }
}

class Solution2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] secFromDate, firToDate, secToDate;
        if (arriveAlice.compareTo(arriveBob) > 0) {
            secFromDate = arriveAlice.split("-");
            firToDate = leaveBob.split("-");
            secToDate = leaveAlice.split("-");
        } else {
            secFromDate = arriveBob.split("-");
            firToDate = leaveAlice.split("-");
            secToDate = leaveBob.split("-");
        }
        Calendar firToCal = new Calendar.Builder().setDate(2023, Integer.valueOf(firToDate[0]) - 1, Integer.valueOf(firToDate[1])).build();
        Calendar secToCal = new Calendar.Builder().setDate(2023, Integer.valueOf(secToDate[0]) - 1, Integer.valueOf(secToDate[1])).build();
        long start = new Calendar.Builder().setDate(2023, Integer.valueOf(secFromDate[0]) - 1, Integer.valueOf(secFromDate[1])).build().getTime().getTime();
        long end = firToCal.getTime().getTime();
        if (firToCal.after(secToCal)) {
            end = secToCal.getTime().getTime();
        }
        return end - start < 0 ? 0 : (int) ((end - start) / 1000 / 60 / 60 / 24) + 1;
    }
}