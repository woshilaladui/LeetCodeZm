package com.whut.algorithm.high.frequence.offer.problem_offer_27_er_cha_shu_de_jing_xiang_lcof;

import org.apdplat.word.vector.T;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/6 17:06
 * @desription
 */
public class ErChaShuDeJingXiangLcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        //前序遍历，如果是非叶子结点就交换左右子树
        doMirrorTree(root);
        return root;
    }

    public void doMirrorTree(TreeNode root){
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null)
            doMirrorTree(root.left);

        if(root.right != null)
            doMirrorTree(root.right);
    }

    public static void main(String[] args) {
    }
}
