package com.whut.algorithm.high.frequence.offer.problem_offer_34_er_cha_shu_zhong_he_wei_mou_yi_zhi_de_lu_jing_lcof;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/9 20:05
 * @desription
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
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


    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

    public static void main(String[] args) {

    }
}
