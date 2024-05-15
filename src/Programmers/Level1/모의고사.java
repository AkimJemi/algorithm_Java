package Programmers.Level1;

import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{1, 2, 3, 4, 5})));
//        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{1, 3, 2, 4, 2})));


        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{2})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{3})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{1})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{1, 1})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{2, 3})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{3, 2})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{2, 3, 3})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{3, 2, 2})));
        System.out.println(Arrays.toString(new Solution모의고사().solution(new int[]{3, 2, 2, 1})));
    }
}

class Solution모의고사 {
    public int[] solution(int[] answers) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answerCount1 = 0;
        int answerCount2 = 0;
        int answerCount3 = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == student1[i % student1.length]) answerCount1++;
            if (answer == student2[i % student2.length]) answerCount2++;
            if (answer == student3[i % student3.length]) answerCount3++;
        }
        boolean answerOne1 = answerCount1 != 0;
        boolean answerOne2 = answerCount2 != 0;
        boolean answerOne3 = answerCount3 != 0;
        boolean answerTwo1 = answerOne1 && answerOne2;
        boolean answerTwo2 = answerOne2 && answerOne3;
        boolean answerTwo3 = answerOne3 && answerOne1;
        if (!answerOne1 && !answerOne2 && !answerOne3)
            return new int[]{};
        if (answerOne1 && !answerOne2 && !answerOne3)
            return new int[]{1};
        if (!answerOne1 && answerOne2 && !answerOne3)
            return new int[]{2};
        if (!answerOne1 && !answerOne2 && answerOne3)
            return new int[]{3};

        boolean compare12 = Integer.compare(answerCount1, answerCount2) != -1;
        boolean compare23 = Integer.compare(answerCount2, answerCount3) != -1;
        boolean compare13 = Integer.compare(answerCount1, answerCount3) != -1;
        if (answerTwo1 && !answerOne3)
            return compare12 ? new int[]{1, 2} : new int[]{2, 1};
        if (answerTwo2 && !answerOne1)
            return compare23 ? new int[]{2, 3} : new int[]{3, 2};
        if (answerTwo3 && !answerOne2)
            return compare13 ? new int[]{1, 3} : new int[]{3, 1};

        if (compare12) {
            if (compare13)
                return new int[]{1, 2, 3};
            else {
                if (compare23) return new int[]{1, 2, 3};
                else return new int[]{1, 3, 2};
            }
        } else {
            if (compare13) return new int[]{2, 1, 3};
            else {
                if (compare23) return new int[]{2, 3, 1};
                else return new int[]{3, 2, 1};
            }
        }
    }
}

/*
 *Someone else's code to study
 * */