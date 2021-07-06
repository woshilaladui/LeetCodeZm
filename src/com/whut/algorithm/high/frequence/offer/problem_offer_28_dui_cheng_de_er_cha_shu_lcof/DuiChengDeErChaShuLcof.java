package com.whut.algorithm.high.frequence.offer.problem_offer_28_dui_cheng_de_er_cha_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/6 17:03
 * @desription
 */
public class DuiChengDeErChaShuLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    /**
     * 剑指offer 28题解
     * @param rootA
     * @param rootB
     * @return
     */
    public boolean isSymmetric(TreeNode rootA,TreeNode rootB){
        if(rootA == null && rootB == null)
            return true;

        if(rootA == null || rootB == null)
            return false;

        if(rootA.val != rootB.val)
            return false;

        return isSymmetric(rootA.left,rootB.right) && isSymmetric(rootA.right,rootB.left);
    }
}
