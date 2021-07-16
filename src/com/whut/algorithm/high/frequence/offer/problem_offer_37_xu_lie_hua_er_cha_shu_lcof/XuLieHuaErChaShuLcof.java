package com.whut.algorithm.high.frequence.offer.problem_offer_37_xu_lie_hua_er_cha_shu_lcof;

import org.apdplat.word.vector.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/16 10:01
 * @desription
 */
public class XuLieHuaErChaShuLcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public String serialize(TreeNode root) {

        if (root == null)
            return "#";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        //根节点入队列
        queue.add(root);

        while (!queue.isEmpty()) {

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append("#,");
                    continue;
                }

                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("#"))
            return null;


        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        //构建根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++) {

            TreeNode parent = queue.poll();

            if(!"#".equals(values[i])){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!"#".equals(values[++i])){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
