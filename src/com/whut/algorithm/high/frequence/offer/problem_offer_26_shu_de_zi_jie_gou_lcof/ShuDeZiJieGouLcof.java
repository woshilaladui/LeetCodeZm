package com.whut.algorithm.high.frequence.offer.problem_offer_26_shu_de_zi_jie_gou_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/6 16:06
 * @desription
 */
public class ShuDeZiJieGouLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;

        if (A != null && B != null) {
            /**
             * 检查根节点是否相等
             */
            if (A.val == B.val)
                result = checkSubStructure(A, B);

            if (!result)
                result = isSubStructure(A.left, B);

            if (!result)
                result = isSubStructure(A.right, B);

        }

        return result;
    }

    /**
     * 检查子树结构
     * @param A
     * @param B
     * @return
     */
    public boolean checkSubStructure(TreeNode A, TreeNode B) {

        /**
         * 递归结束条件A B遍历到叶子结点
         */

        /**
         * 注意顺序
         *
         *   1       3
         *  2  3
         *
         *
         */
        if (B == null)
            return true;

        if (A == null)
            return false;

        if (A.val != B.val)
            return false;

        return checkSubStructure(A.left, B.left) && checkSubStructure(A.right, B.right);

    }
}
