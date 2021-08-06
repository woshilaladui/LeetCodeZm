package com.whut.algorithm.high.frequence.offer.problem_offer_55_2_ping_heng_er_cha_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/5 19:45
 * @desription
 */
public class PingHengErChaShuLcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * O(n2) 自顶向下重复计算节点
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(height1(root.left) - height1(root.right)) <= 1 &&
                isBalanced1(root.left) &&
                isBalanced1(root.right);


    }

    private int height1(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(height1(root.left), height1(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        /**
         * 其中leftHeight  rightHeight = -1 说明已经前面有不满足平衡二叉树定义
         */
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }

    }


    public static void main(String[] args) {

    }
}
