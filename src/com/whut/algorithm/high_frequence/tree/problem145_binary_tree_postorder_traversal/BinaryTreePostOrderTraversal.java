package com.whut.algorithm.high_frequence.tree.problem145_binary_tree_postorder_traversal;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 10:03
 * @desription
 */
public class BinaryTreePostOrderTraversal {
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

    public static List<Integer> postorderTraversal(TreeNode root) {


        Map<TreeNode, Integer> map = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new LinkedList<>();

        while (root != null || !stack.empty()) {

            //将左结点入栈
            while (root != null) {
                stack.push(root);
                //标记该结点右节点没有被访问过
                map.put(root, 0);
                root = root.left;
            }

            while (!stack.empty() && map.get(stack.peek()) == 1) {
                result.add(stack.pop().val);
            }

            if (!stack.empty()) {
                //标记该结点右节点访问过了
                map.put(stack.peek(), 1);
                root = stack.peek().right;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;

        treeNode2.left = treeNode3;

        List<Integer> reslut = postorderTraversal(treeNode1);

        for (Integer integer : reslut) {
            System.out.print(integer);
        }

    }
}
