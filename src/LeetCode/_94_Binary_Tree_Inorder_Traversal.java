package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _94_Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {
//        System.out.println(new Solution94().inorderTraversal());
    }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root.left != null) {
            return recursionFunction(new ArrayList<Integer>(), root.left, root);
        } else if (root.right != null) {
            return recursionFunction(new ArrayList<Integer>(), root.right, root);
        } else {
            return new ArrayList<Integer>();
        }
    }

    private List<Integer> recursionFunction(List<Integer> list, TreeNode target, TreeNode previous) {
        if (target == null) {
            return list;
        }
//        if(target.left == null && target.right == null){
//            list.add(target.val);
//            recursionFunction(list ,previous,  target);
//        }
        if (target.left != null) {
            recursionFunction(list, target.left, target);
        } else {
            list.add(target.val);
        }
        if (target.right != null) {
            recursionFunction(list, target.right, target);
        }
        return list;
    }
}



