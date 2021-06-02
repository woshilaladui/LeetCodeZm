package com.whut.algorithm.high.frequence.problem102_binary_tree_level_order_traversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/31 20:55
 * @desription
 */
public class BinaryTreeLevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        //根节点入队列
        queue.add(root);
        result.add(new LinkedList<Integer>() {{
            add(root.val);
        }});

        while (!queue.isEmpty()) {

            int sz = queue.size();

            LinkedList<Integer> path = new LinkedList<>();

            for (int i = 0; i < sz; i++) {

                TreeNode treeNode = queue.poll();

                //
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    path.addLast(treeNode.left.val);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    path.addLast(treeNode.right.val);
                }

            }
            if (path.size() > 0)
                result.add(path);

        }
        Collections.reverse(result);
//        for (List<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }

       // Collections.reverse(result);
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

        levelOrder(treeNode3);

    }
}
