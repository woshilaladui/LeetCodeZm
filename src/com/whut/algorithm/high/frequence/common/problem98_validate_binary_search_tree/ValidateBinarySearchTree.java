package com.whut.algorithm.high.frequence.common.problem98_validate_binary_search_tree;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/18 20:49
 * @desription
 */
public class ValidateBinarySearchTree {

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

    private static int preData = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {


        boolean bl,br;

        if(root == null )
            return true;

        else {
            bl = isValidBST(root.left);

            if(!bl || preData >= root.val )
                return false;

            preData = root.val;

            br = isValidBST(root.right);

            return br;
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0,null,null);
        treeNode.left = new TreeNode(-1);

        System.out.println(isValidBST(treeNode));
    }
}
