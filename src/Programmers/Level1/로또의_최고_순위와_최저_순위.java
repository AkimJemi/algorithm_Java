package Programmers.Level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
//        System.out.println(new Solution로또의_최고_순위와_최저_순위().solution(""));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
//        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
        System.out.println(Arrays.toString(new Solution로또의_최고_순위와_최저_순위().solution(new int[]{6, 5, 0, 0, 4, 0}, new int[]{4, 1, 2, 0, 7, 8})));
    }
}

class Solution로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottosList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int max = 0;
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottosList.remove((Integer) 0)) {
                max++;
                continue;
            }
            if (winNumsList.contains(lottosList.get(0))) count++;
            lottosList.remove(0);
        }
        return new int[]{7 - count - max != 7 ? 7 - count - max : 6, 7 - count != 7 ? 7 - count : 6};
    }

    /*
     *Someone else's code to study
     * */
    public int[] solution1(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i : lottos) {
            if (i == 0) {
                cnt1++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) cnt2++;
            }
        }
        answer[0] = getGrade(cnt1 + cnt2);
        answer[1] = getGrade(cnt2);
        return answer;
    }

    public int getGrade(int n) {
        switch (n) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public int[] solution2(int[] lottos, int[] winNums) {
        return LongStream.of(
                        (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                        (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
                )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }

    public int[] solution3(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int answer = 0;
        int hidden = 0;
        Arrays.sort(win_nums);
        for (int i = 0; i < lottos.length; i++)
            if (Arrays.binarySearch(win_nums, lottos[i]) > -1)
                answer++;
            else if (lottos[i] == 0)
                hidden++;

        return new int[]{rank[answer + hidden], rank[answer]};
    }
}

