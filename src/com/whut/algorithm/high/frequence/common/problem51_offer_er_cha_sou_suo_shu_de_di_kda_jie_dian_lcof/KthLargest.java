package com.whut.algorithm.high.frequence.common.problem51_offer_er_cha_sou_suo_shu_de_di_kda_jie_dian_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/1 9:58
 * @desription
 */
public class KthLargest {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k, result;

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。 用改进版本的中序递归
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderTraversal(root);
        return this.result;
    }

    public void inOrderTraversal(TreeNode root) {
        if(root == null)
            return;
        inOrderTraversal(root.right);

        if(--this.k == 0)
            this.result = root.val;

        System.out.print(root.val+" ");
//
        if(k == 0)
            return;

        inOrderTraversal(root.left);
    }

    public static void main(String[] args) {
        /**
         * [3,1,4,null,2]
         * 1
         */
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;

        KthLargest kthLargest = new KthLargest();
        kthLargest.kthLargest(treeNode3,1);
        System.out.println();
    }
}
