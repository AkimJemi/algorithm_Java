package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _83_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
//        ListNode listNode = NodeUtils.getNodeFromIntegerArray(new Integer[]{});
//        listNode = new Solution83().deleteDuplicates(listNode);
//        List<Integer> list = NodeUtils.getIntegerListFromNode(listNode);
//        System.out.println(list);
    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (true) {
            if (head.next == null) break;
            if (head.val == head.next.val) {
                head = head.next;
                continue;
            }
            list.add(head.next.val);
            head = head.next;
        }
        ListNode node = new ListNode(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--)
            node = new ListNode(list.get(i), node);

        return node;
    }

    /* someone else's code to study */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }
}