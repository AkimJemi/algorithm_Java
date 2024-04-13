import org.w3c.dom.NodeList;

import java.util.*;

public class _19_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode node = new Solution19().removeNthFromEnd(List.of(1, 2, 3, 4, 5).stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
                    b.next = a;
                    return b;
                }
        ).get(), 2);
    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> intList = new ArrayList<>();
        while (true) {
            if (head != null) {
                intList.add(head.val);
            }
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        intList.remove(intList.size() - n);
        Collections.reverse(intList);
        Optional<ListNode> optional = intList.stream().map(a -> new ListNode(a)).reduce((a, b) -> {
                    b.next = a;
                    return b;
                }
        );
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

