package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _729_My_Calendar_I {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(3, 5);
        myCalendar.book(1, 3);


    }
}

class MyCalendar {
    List<int[]> bookedCal;

    public MyCalendar() {
        bookedCal = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (bookedCal.size() == 0) {
            bookedCal.add(new int[]{start, end});
            return true;
        }
        for (int[] bookArray : bookedCal) {
            int bookedStart = bookArray[0];
            int bookedEnd = bookArray[1];
            if ((bookedStart <= start && end < bookedEnd) || (start < bookedStart && bookedStart < end) || (start < bookedEnd && bookedEnd <= end)) {
                return false;
            }
        }
        bookedCal.add(new int[]{start, end});
        return true;
    }
}

// others code
class MyCalendar2 {

    class Node {
        int start;
        int end;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendar2() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        Node curr = root;
        while (curr != null) {
            if (end <= curr.start) {
                if (curr.left == null) {
                    curr.left = new Node(start, end);
                    return true;
                }
                curr = curr.left;
            } else if (start >= curr.end) {
                if (curr.right == null) {
                    curr.right = new Node(start, end);
                    return true;
                }
                curr = curr.right;
            } else return false;
        }
        return false;
    }
}