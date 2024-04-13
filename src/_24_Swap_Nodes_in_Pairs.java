import java.util.*;

public class _24_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
        ListNode node1 = List.of(1).stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
                    b.next = a;
                    return b;
                }
        ).get();
        System.out.println(new Solution24().swapPairs(node1));

    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        List<Integer> intList = new ArrayList<>();
        while (true) {
            if (head != null) {
                intList.add(head.val);
                head = head.next;
            }
            if (head == null) {
                break;
            }
        }
        System.out.println(intList);
        if (intList.size() > 1) {
            for (int i = 0; i < intList.size() - 1; i += 2) {
                int first = intList.get(i);
                int second = intList.get(i + 1);
                intList.set(i, second);
                intList.set(i + 1, first);
            }
        }
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
