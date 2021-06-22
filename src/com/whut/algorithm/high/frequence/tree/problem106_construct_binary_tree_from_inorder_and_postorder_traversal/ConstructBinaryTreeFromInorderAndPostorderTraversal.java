package com.whut.algorithm.high.frequence.tree.problem106_construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 9:45
 * @desription
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, map, 0, inorder.length - 1);

    }

    private static TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map, int inLeft, int inRight) {

        if (postLeft > postRight)
            return null;

        int postOrderValue = postorder[postRight];

        int postIndex = map.get(postOrderValue);

        TreeNode root = new TreeNode(postOrderValue);

        root.left = buildTree(
                postorder,
                postLeft,
                postIndex - inLeft + postLeft-1,
                map,
                inLeft,
                postIndex - 1
        );

        root.right = buildTree(
                postorder,
                postIndex - inLeft + postLeft ,
                postRight - 1,
                map,
                postIndex + 1,
                inRight
        );

        return root;

    }

    public static void main(String[] args) {

        int []inorder = new int[]{9,3,15,20,7};
        int []postorder = new int[]{9,15,7,20,3};

        TreeNode root = buildTree(inorder,postorder);

        preOrder(root);

    }

    private static void preOrder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
