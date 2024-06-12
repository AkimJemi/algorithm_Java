package LeetCode;

public class _100_Same_Tree {
    public static void main(String[] args) {
        TreeNode2 f = new TreeNode2(1, new TreeNode2(2), new TreeNode2(3));
        System.out.println(new Solution100().isSameTree(f, f));
    }
}

class Solution100 {
    public boolean isSameTree(TreeNode2 p, TreeNode2 q) {
        if (p != null && q != null) return backtracking(p, q);
        else if (p == null && q == null) return true;
        else return false;
    }

    private boolean backtracking(TreeNode2 p, TreeNode2 q) {
        if (p.val != q.val) return false;
        if (p.right != null) {
            if (q.right != null) {
                if (!backtracking(p.right, q.right)) return false;
            } else return false;
        } else if (q.right != null) return false;
        if (p.left != null) {
            if (q.left != null) {
                if (!backtracking(p.left, q.left)) return false;
            } else return false;
        } else if (q.left != null) return false;
        return true;
    }
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
