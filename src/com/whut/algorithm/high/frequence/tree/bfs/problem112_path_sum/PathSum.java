package com.whut.algorithm.high.frequence.tree.bfs.problem112_path_sum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/6 12:32
 * @desription
 */
public class PathSum {


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


    public static boolean hasPathSum(TreeNode root, int targetSum) {

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        if(root == null)
            return false;

        //根节点入队列
        queue.offer(root);
        sumQueue.offer(root.val);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode treeNode = queue.poll();
                int temp = sumQueue.poll();

                if(treeNode.left == null && treeNode.right == null){
                    if(temp == targetSum)
                        return true;
                    continue;
                }

                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                    sumQueue.offer(treeNode.left.val + temp);
                }

                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                    sumQueue.offer(treeNode.right.val + temp);
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;

        System.out.println(hasPathSum(treeNode1,2));
    }
}
