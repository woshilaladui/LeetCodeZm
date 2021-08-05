package com.whut.algorithm.high.frequence.common.problem110_balanced_binary_tree;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 14:26
 * @desription
 */
public class BalancedBinaryTree {

    public static class TreeNode {
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

    public static boolean isBalanced(TreeNode root) {

        int hl = 0, hr = 0;

        if (root == null)
            return true;

        hl = height(root.left);

        hr = height(root.right);

        if (Math.abs(hl - hr) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public static int height(TreeNode root) {

        if (root == null)
            return 0;

        int hl = height(root.left);
        int hr = height(root.right);

        return Math.max(hl, hr) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode6;

        System.out.println(isBalanced(treeNode1));

        int a = 1000000008%1000000007;

        System.out.println(a);

    }
}
