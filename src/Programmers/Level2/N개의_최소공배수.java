package Programmers.Level2;

public class N개의_최소공배수 {
    public static void main(String[] args) {

        System.out.println(new SolutionN개의_최소공배수().solution(new int[]{2, 6, 8, 14}));
    }
}

class SolutionN개의_최소공배수 {
    public int solution(int[] arr) {
        int target = arr[0];
        int i = 0;
        boolean flag = false;
        while (true) {
            for (i = 0; i < arr.length; i++) {
                if (target % arr[i] != 0) {
                    flag = false;
                    target++;
                    break;
                } else {
                    flag = true;
                }
            }
            if (i == arr.length && flag) {
                break;
            }
        }
        return target;
    }
}