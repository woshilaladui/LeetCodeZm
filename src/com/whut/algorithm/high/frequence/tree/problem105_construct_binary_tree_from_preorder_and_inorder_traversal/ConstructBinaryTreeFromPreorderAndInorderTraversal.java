package com.whut.algorithm.high.frequence.tree.problem105_construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 9:13
 * @desription
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //存放前序根结点在中序序列的位置
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);

    }

    private TreeNode buildTree(
            int[] preorder,
            int preLeft,
            int preRight,
            Map<Integer, Integer> map,
            int inLeft,
            int inRight
    ) {

        //保证不越界
        if(preLeft > preRight)
            return null;

        int preOrderValue = preorder[preLeft];

        TreeNode root = new TreeNode(preOrderValue);

        int preIndex = map.get(preOrderValue);

        root.left = buildTree(
                preorder,
                preLeft + 1,  //前序序列的左子树起始节点
                preIndex - inLeft + preLeft, //前序序列左子树终止结点
                map,
                inLeft, //中序序列左子树起始节点
                preIndex - 1//中序序列左子树终止结点
        );

        root.right = buildTree(
                preorder,
                preIndex - inLeft + preLeft + 1,//前序序列右子树的起始节点
                preRight,//前序序列右子树的终止结点
                map,
                preIndex + 1,//中序序列右子树起始结点
                inRight//中序序列右子树的终止结点
        );


        return root;
    }


    public static void main(String[] args) {

    }
}
