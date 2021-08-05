package com.whut.algorithm.high.frequence.common.problem449_serialize_and_deserialize_bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 20:03
 * @desription
 */
public class SerializeAndDeserializeBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static String serialize(TreeNode root) {
        if (root == null)
            return "#";

        Queue<TreeNode> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        queue.add(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode == null) {
                    sb.append("#,");
                    continue;
                }

                sb.append(treeNode.val).append(",");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        if (data.equals("#"))
            return null;

        Queue<TreeNode> queue = new LinkedList<>();

        String[] values = data.split(",");

        //构造根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        //根结点入队
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();

            //left
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            //right
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        System.out.println(serialize(treeNode2));

        System.out.println();
    }
}
