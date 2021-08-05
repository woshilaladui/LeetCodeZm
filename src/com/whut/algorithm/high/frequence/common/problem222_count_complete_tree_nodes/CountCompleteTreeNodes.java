package com.whut.algorithm.high.frequence.common.problem222_count_complete_tree_nodes;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/20 9:01
 * @desription
 */
public class CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

    }
}
