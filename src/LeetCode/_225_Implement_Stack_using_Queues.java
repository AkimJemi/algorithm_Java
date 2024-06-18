package LeetCode;

import java.util.*;

public class _225_Implement_Stack_using_Queues {
}

class MyStack {
    List<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int value = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return value;
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */