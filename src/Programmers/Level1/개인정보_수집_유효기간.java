package Programmers.Level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            if (!todayCal.before(expirationPeriodCal)) {
                resultList.add(i + 1);
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
 *Someone else's code to study
 * */
class Solution개인정보_수집_유효기간1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
class Solution개인정보_수집_유효기간2 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(today, formatter);

        // 찾기 쉽도록 termsMap 구성
        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.valueOf(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate privacyRegisterYmdt = LocalDate.parse(privacy[0], formatter).plusMonths(termsMap.get(privacy[1])).minusDays(1);
            if (privacyRegisterYmdt.isBefore(date)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}