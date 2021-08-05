package com.whut.algorithm.high.frequence.common.problem543_diameter_of_binary_tree;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/11 18:11
 * @desription
 */
public class DiameterOfBinaryTree {

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

    private static int result;

    public static int deepth(TreeNode treeNode) {

        if (treeNode == null)
            return 0;

        int L = deepth(treeNode.left);
        int R = deepth(treeNode.right);

        result = Math.max(result, L + R + 1);

//        if (L > R) {
//            return L + 1;
//        } else {
//            return R + 1;
//        }

        return Math.max(L, R) + 1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        result = 0;

        deepth(root);

        return result - 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;

        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(diameterOfBinaryTree(treeNode1));

    }
}
