package LeetCode;


class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
        System.out.println(new Solution약수의_개수와_덧셈().solution(13, 17));
        System.out.println(new Solution약수의_개수와_덧셈().solution(24, 27));
    }
}

class Solution약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) cnt++;
                else if (i % j == 0) cnt += 2;
            }
            if (cnt % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}

/*
 *Someone else's code to study
 * */