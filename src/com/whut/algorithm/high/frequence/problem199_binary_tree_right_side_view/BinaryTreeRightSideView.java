package com.whut.algorithm.high.frequence.problem199_binary_tree_right_side_view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 12:42
 * @desription
 */
public class BinaryTreeRightSideView {
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

    /**
     * 层次遍历最后一个结点就是
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        if (root == null)
            return result;

        queue.add(root);


        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {

                TreeNode treeNode = queue.poll();

                // System.out.println(treeNode.val);

                if (i == sz - 1)
                    result.add(treeNode.val);

                if (treeNode.left != null)
                    queue.add(treeNode.left);

                if (treeNode.right != null)
                    queue.add(treeNode.right);
            }
        }

//        for (Integer integer : result) {
//            System.out.print(integer+" ");
//        }

        return result;
    }

    public static void main(String[] args) {
//[1,2,3,null,5,null,4]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.right = treeNode5;

        treeNode3.right = treeNode4;


        rightSideView(treeNode1);

    }
}
