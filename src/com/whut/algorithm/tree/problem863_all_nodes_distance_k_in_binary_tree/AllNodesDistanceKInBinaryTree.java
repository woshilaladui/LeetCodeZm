package com.whut.algorithm.tree.problem863_all_nodes_distance_k_in_binary_tree;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/27 19:34
 * @desription
 */
public class AllNodesDistanceKInBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * 思想：先将树构造成图，然后再bfs
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();

        dfs(root, null);
        if (root == null)
            return result;


        Queue<TreeNode> queue = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();

        //根节点入队列
        queue.add(target);
        visited.add(target);

        int dis = 0;

        while (!queue.isEmpty()) {

            int sz = queue.size();

            if (dis == K)
                break;

            for (int i = 0; i < sz; i++) {
                //出队列
                TreeNode temp = queue.poll();

                //访问左节点
                if (temp.left != null && !visited.contains(temp.left)) {
                    queue.add(temp.left);
                    visited.add(temp.left);
                }

                if (temp.right != null && !visited.contains(temp.right)) {
                    queue.add(temp.right);
                    visited.add(temp.right);
                }

                //父节点
                if (map.containsKey(map.get(temp)) && !visited.contains(map.get(temp))) {
                    queue.add(map.get(temp));
                    visited.add(map.get(temp));
                }

            }//end for
            dis++;

        }

        //队列里都是距离target距离为k的结点
        while (!queue.isEmpty()) {
            result.add(queue.peek().val);
            queue.poll();
        }

        return result;
    }

    private static void dfs(TreeNode root, TreeNode father) {
        if (root == null)
            return;
        map.put(root, father);
        dfs(root.left, root);
        dfs(root.right, root);
    }


    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;

        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;


        List<Integer> result = distanceK(treeNode3, treeNode5, 2);

        for (Integer integer : result) {
            System.out.println(integer+" ");
        }


    }
}
