import java.util.*;

public class _21_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode node1 = List.of(2).stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
                    b.next = a;
                    return b;
                }
        ).get();
        ListNode node2 = List.of(1).stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
                    b.next = a;
                    return b;
                }
        ).get();
        System.out.println(new Solution21().mergeTwoLists(node1, node2));
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> intList = new ArrayList<>();
        while (true) {
            if (list1 != null) {
                intList.add(list1.val);
                list1 = list1.next;
            }
            if (list2 != null) {
                intList.add(list2.val);
                list2 = list2.next;
            }
            if (list1 == null && list2 == null) {
                break;
            }
        }
        while (true) {
            if (list2 != null) {
                intList.add(list2.val);
                list2 = list2.next;
            }
            if (list2 == null) {
                break;
            }
        }
        Optional<ListNode> optional = intList.stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
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