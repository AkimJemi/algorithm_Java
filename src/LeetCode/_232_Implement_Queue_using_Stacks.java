package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _232_Implement_Queue_using_Stacks {
    public static void main(String[] args) {

    }
}

class MyQueue {
    Queue<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.poll();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */