package com.sweartooffer;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int m = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int result = computePath(root);
        return result > m ? result : m;
    }

    public int computePath(TreeNode root) {

        if (root == null)
            return 0;

        int l = computePath(root.left);
        int r = computePath(root.right);

        int leftValue = Math.max(l, 0);
        int rightValue = Math.max(r, 0);

        m = Math.max(m, leftValue + rightValue + root.val);

        return root.val + Math.max(leftValue, rightValue);
    }

}
