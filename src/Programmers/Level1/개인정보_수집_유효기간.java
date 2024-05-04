package Programmers.Level1;

import java.util.*;
import java.util.stream.Collectors;

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution개인정보_수집_유효기간().solution(
                        "2022.05.19",
                        new String[]{"A 6", "B 12", "C 3"},
                        new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(
                new Solution개인정보_수집_유효기간().solution(
                        "2020.01.01",
                        new String[]{"Z 3", "D 5"},
                        new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}

class Solution개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todaySplit = today.split("\\.");
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(new Date(Integer.valueOf(todaySplit[0]), Integer.valueOf(todaySplit[1]) - 1, Integer.valueOf(todaySplit[2])));
        Map<String, Integer> termsMap = Arrays.stream(terms).collect(Collectors.toMap(a -> a.split(" ")[0], a -> Integer.valueOf(a.split(" ")[1])));
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String privacyTermType = privacy[1];
            String[] privacyDate = privacy[0].split("\\.");
            Calendar expirationPeriodCal = Calendar.getInstance();
            expirationPeriodCal.setTime(new Date(Integer.valueOf(privacyDate[0]), Integer.valueOf(privacyDate[1]) - 1, Integer.valueOf(privacyDate[2])));
            expirationPeriodCal.add(Calendar.MONTH, termsMap.get(privacyTermType));
            if (todayCal.after(expirationPeriodCal) || todayCal.equals(expirationPeriodCal)) {
                resultList.add(i + 1);
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
