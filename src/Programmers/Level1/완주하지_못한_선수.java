package Programmers.Level1;

import java.util.Arrays;

class 완주하지_못한_선수 {
    public static void main(String[] args) {
        System.out.println(new Solution완주하지_못한_선수().solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(new Solution완주하지_못한_선수().solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(new Solution완주하지_못한_선수().solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}

class Solution완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length - 1; i++)
            if (!participant[i].equals(completion[i])) return participant[i];
        return participant[participant.length - 1];
    }
}

/*
 *Someone else's code to study
 * */