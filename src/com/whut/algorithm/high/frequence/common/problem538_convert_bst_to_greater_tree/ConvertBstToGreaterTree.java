package com.whut.algorithm.high.frequence.common.problem538_convert_bst_to_greater_tree;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 20:16
 * @desription
 */
public class ConvertBstToGreaterTree {
    public class TreeNode {
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

    static int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val =  sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
