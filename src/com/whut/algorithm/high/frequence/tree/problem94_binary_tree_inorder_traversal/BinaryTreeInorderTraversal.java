package com.whut.algorithm.high.frequence.tree.problem94_binary_tree_inorder_traversal;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 10:44
 * @desription
 */
public class BinaryTreeInorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                result.add(stack.peek().val);

                root = stack.pop().right;
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//
//        treeNode1.right = treeNode2;
//        treeNode2.left = treeNode3;
//
//        List<Integer> result = inorderTraversal(treeNode1);
//
//        for (Integer integer : result) {
//            System.out.print(integer);
//        }
        System.out.println("asd");
    }
}
