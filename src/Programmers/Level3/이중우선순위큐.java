package Programmers.Level3;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution이중우선순위큐().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(new Solution이중우선순위큐().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}
class Solution이중우선순위큐 {
    public int[] solution(String[] operations) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            int num = Integer.valueOf(operation[1]);
            String oper = operation[0];
            if (oper.equals("D")) {
                if (!numList.isEmpty()) {
                    if (num == 1) {
                        numList.remove(numList.stream().max(Comparator.naturalOrder()).get());
                    } else {
                        numList.remove(numList.stream().min(Comparator.naturalOrder()).get());
                    }
                }
            } else numList.add(num);
        }
        return numList.isEmpty() ? new int[]{0, 0} : new int[]{numList.stream().max(Comparator.naturalOrder()).get(), numList.stream().min(Comparator.naturalOrder()).get()};
    }
    /*
     *Someone else's code to study
     * */
    public int[] solution1(String[] arguments) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<arguments.length; i++) {
            String temp[] = arguments[i].split(" ");
            switch(temp[0]) {
                case "I" :
                    pq.add(Integer.parseInt(temp[1]));
                    reverse_pq.add(Integer.parseInt(temp[1]));
                    break;
                case "D" :
                    if(pq.size() > 0) {
                        if(Integer.parseInt(temp[1]) == 1) {
                            // 최댓값 삭제
                            int max = reverse_pq.poll();
                            pq.remove(max);
                        } else {
                            // 최솟값 삭제
                            int min = pq.poll();
                            reverse_pq.remove(min);
                        }
                    }
                    break;
            }
        }
        if(pq.size() >= 2) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
    public int[] solution2(String[] operations) {
        Queue<Integer> minpq = new PriorityQueue<>();
        Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                minpq.offer(n);
                maxpq.offer(n);
            } else if (!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            } else if (!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            }
        }
        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxpq.poll(), minpq.poll()};
    }
}