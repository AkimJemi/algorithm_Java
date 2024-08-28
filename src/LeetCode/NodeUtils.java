package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {
    public static ListNode getNodeFromIntegerArray(Integer[] intArray) {
        ListNode node = new ListNode(intArray[intArray.length - 1]);
        for (int i = intArray.length - 2; i >= 0; i--) {
            node = new ListNode(intArray[i], node);
        }
//        for (int i = intArray.length - 2; i > 0; i--) {
//            node = new ListNode(node.val, new ListNode(intArray[i]));
//        }
        return node;
//        return List.of(intArray).stream().sorted(Comparator.reverseOrder()).map(a -> new ListNode(a)).reduce((a, b) -> {
//                    b.next = a;
//                    return b;
//                }
//        ).get();
    }

    public static List<Integer> getIntegerListFromNode(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(listNode.val);
            if (listNode.next == null) {
                break;
            }
            listNode = listNode.next;
        }
        return list;
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

class TreeNode {

    public static TreeNode getTreeNodeFromIntegerArray(Integer[] intArray) {
        TreeNode node = new TreeNode(intArray[intArray.length - 1]);
//        for (int i = intArray.length - 2; i >= 0; i--) {
//            node = new TreeNode(intArray[i], node);
//        }
        return node;
    }


    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
