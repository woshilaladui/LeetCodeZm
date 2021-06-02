package com.whut.algorithm.high.frequence.tree.problem144_binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 10:22
 * @desription
 */
public class BinaryTreePreorderTraversal {

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

    public static List<Integer> preorderTraversal(TreeNode root) {
//
//        List<Integer> result = new LinkedList<>();
//
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (root != null || !stack.empty()) {
//            //沿着做左分支找
//            if(root != null){
//                result.add(root.val);
//                stack.push(root);
//                root = root.left;
//            }else {
//                root = stack.pop();
//                root = root.right;
//            }
//        }
//
//        return result;

        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        //根结点入栈
        stack.push(root);

        while (!stack.empty()) {
            //访问根结点
            root = stack.pop();

            if (root != null)
                result.add(root.val);

            //先将右子树入栈，再将左子树入栈
            if (root != null && root.right != null)
                stack.push(root.right);
            if (root != null && root.left != null)
                stack.push(root.left);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;

        treeNode2.left = treeNode3;

        List<Integer> result = preorderTraversal(null);

        for (Integer integer : result) {
            System.out.print(integer);
        }
    }
}
