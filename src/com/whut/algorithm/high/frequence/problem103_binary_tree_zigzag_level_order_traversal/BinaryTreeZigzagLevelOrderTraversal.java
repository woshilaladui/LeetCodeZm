package com.whut.algorithm.high.frequence.problem103_binary_tree_zigzag_level_order_traversal;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/7 9:49
 * @desription
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        queue.add(root);

        boolean isLeft = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode treeNode = queue.poll();

                if (isLeft) {
                    deque.addLast(treeNode.val);
                } else {
                    deque.addFirst(treeNode.val);
                }

                if (treeNode.left != null)
                    queue.offer(treeNode.left);

                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }

            result.add(new LinkedList<>(deque));
            isLeft = !isLeft;

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;

        treeNode3.right = treeNode20;

        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        List<List<Integer>> result = zigzagLevelOrder(treeNode3);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
