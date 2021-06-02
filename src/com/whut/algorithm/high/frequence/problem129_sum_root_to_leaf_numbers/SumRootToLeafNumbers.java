package com.whut.algorithm.high.frequence.problem129_sum_root_to_leaf_numbers;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/1 8:34
 * @desription
 */
public class SumRootToLeafNumbers {


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

    public static int sumNumbers(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();

        nodeQueue.offer(root);
        numQueue.offer(root.val);
        int sum = 0;

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }

                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }

        }


        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        System.out.println(sumNumbers(treeNode1));
    }
}
