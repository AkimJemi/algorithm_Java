package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class 옹알이2 {
    public static void main(String[] args) {
        System.out.println(new Solution옹알이2().solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(new Solution옹알이2().solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}

class Solution옹알이2 {
    public int solution(String[] babbling) {
        List<String> list2 = new ArrayList<>(List.of("ye", "ma"));
        List<String> list3 = new ArrayList<>(List.of("aya", "woo"));
        int count = 0;
        for (String babb : babbling) {
            while (true) {
                if (babb.length() >= 3) {
                    String prefix3 = babb.substring(0, 3);
                    if (list3.contains(prefix3)) {
                        if (babb.length() >= 6) {
                            String prefix33 = babb.substring(3, 6);
                            if (prefix3.equals(prefix33)) {
                                break;
                            }
                        }
                        babb = babb.replaceFirst(prefix3, "");
                        continue;
                    }
                }
                if (babb.length() >= 2) {
                    String prefix2 = babb.substring(0, 2);
                    if (list2.contains(prefix2)) {
                        if (babb.length() >= 4) {
                            String prefix22 = babb.substring(2, 4);
                            if (prefix2.equals(prefix22)) {
                                break;
                            }
                        }
                        babb = babb.replaceFirst(prefix2, "");
                        continue;
                    }
                }
                break;
            }
            if (babb.length() == 0) {
                count++;
            }
        }
        return count;
    }
}

/*
 *Someone else's code to study
 * */