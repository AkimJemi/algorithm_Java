package LeetCode;


public class _112_Path_Sum {
    public static void main(String[] args) {
//        new Solution112().hasPathSum(NodeUtils.getNodeFromIntegerArray(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 5);
    }
}


class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        int num = 0;
        sum += root.val;
        if (root.left != null) {
            hasPathSum(root.left, targetSum, sum);
        } else {
            if (sum == targetSum) {
                return true;
            }
        }
        if (root.right != null) {
            hasPathSum(root.right, targetSum, sum);
        } else {
            if (sum == targetSum) {
                return true;
            }
        }
        return false;
    }
}