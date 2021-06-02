package com.whut.algorithm.high.frequence.problem572_subtree_of_another_tree;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/17 9:55
 * @desription
 */
public class SubtreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return dfs(root,subRoot);
    }

    private boolean dfs(TreeNode root,TreeNode subRoot){
        //递归终止
        if(root == null)
            return false;

        return check(root,subRoot) || dfs(root.left,subRoot) || dfs(root.right,subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {

        //递归终止
        if(root == null && subRoot == null)
            return true;

        if(root == null || subRoot == null || root.val != subRoot.val)
            return false;

        return check(root.left,subRoot.left) && check(root.right,subRoot.right);

    }

    public static void main(String[] args) {

    }
}
