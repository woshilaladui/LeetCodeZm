package com.whut.algorithm.high.frequence.offer.problem_offer_07_chong_jian_er_cha_shu_lcof;

import org.apdplat.word.vector.T;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/22 10:25
 * @desription 和leetcode 105题目一样
 */
public class ChongJianErChaShuLcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //映射前序元素在中序的位置
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(
                preorder,
                0,
                preorder.length - 1,
                map,
                0,
                inorder.length - 1
        );
    }

    public TreeNode buildTree(
            int[] preorder,
            int preLeft,
            int preRight,
            Map<Integer, Integer> map,
            int inLeft,
            int inRight
    ) {

        //保证不越界
        if (preLeft > preRight)
            return null;

        int preOrderValue = preorder[preLeft];

        TreeNode treeNode = new TreeNode(preOrderValue);

        int pIndex = map.get(preOrderValue);

        treeNode.left = buildTree(
                preorder,
                preLeft + 1,
                pIndex - inLeft + preLeft,
                map,
                inLeft, //中序序列左子树起始节点
                pIndex - 1//中序序列左子树终止结点
        );

        treeNode.right = buildTree(
                preorder,
                pIndex - inLeft + preLeft + 1,
                preRight,
                map,
                pIndex + 1,//中序序列右子树起始结点
                inRight//中序序列右子树的终止结点
        );

        return treeNode;
    }

    public static void main(String[] args) {

    }
}
