package com.whut.algorithm.high.frequence.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/1 10:25
 * @desription
 */
public class TreeUtils {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * # 表示null
     * <p>
     * [2,1,3,#,#,#,#]
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {

        Queue<TreeNode> queue = new LinkedList<>();

        String[] values = data.split(",");

        //根节点入队列
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();

            //left
            if (!"#".equals(values[i])) {
                //左节点入队
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                assert parent != null;
                parent.left = left;
                queue.offer(left);
            }

            if (!"#".equals(values[++i])) {
                //右节点入队
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                assert parent != null;
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        //[3,1,4,null,2]
        String values = "3,1,4,#,2,#,#";

        TreeNode treeNode = deserialize(values);

        System.out.println();

    }


}
