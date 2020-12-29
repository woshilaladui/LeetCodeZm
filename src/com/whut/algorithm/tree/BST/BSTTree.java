package com.whut.algorithm.tree.BST;

import com.whut.algorithm.tree.TreeNode;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/29 15:26
 * @desription
 */
public class BSTTree {

    private static int predata = Integer.MIN_VALUE;

    /**
     * 通过中序遍历来判断
     *
     * @param treeNode
     * @return
     */
    public boolean isValidBST1(TreeNode treeNode) {

        boolean bl, br;

        if (treeNode == null)
            return true;
        else {
            //中序遍历
            bl = isValidBST1(treeNode.left);

            if (!bl || predata >= Integer.parseInt(treeNode.val))
                return false;

            predata = Integer.parseInt(treeNode.val);

            br = isValidBST1(treeNode.right);

            return br;
        }

    }

    public boolean isValidBST2(TreeNode treeNode) {
        return isValidBST2(treeNode, null, null);
    }

    public boolean isValidBST2(TreeNode treeNode, TreeNode min, TreeNode max) {
        if (treeNode == null)
            return true;
        if (min != null && Integer.parseInt(treeNode.val) <= Integer.parseInt(min.val))
            return false;

        if (max != null && Integer.parseInt(treeNode.val) >= Integer.parseInt(max.val))
            return false;

        return isValidBST2(treeNode.left, min, treeNode)
                &&
                isValidBST2(treeNode.right, treeNode, max);
    }

    boolean isInBSTTree(TreeNode treeNode, int target) {

        if (treeNode == null)
            return false;

        if (Integer.parseInt(treeNode.val) == target)
            return true;

        if (Integer.parseInt(treeNode.val) > target)
            return isInBSTTree(treeNode.left, target);

        if (Integer.parseInt(treeNode.val) < target)
            return isInBSTTree(treeNode.right, target);

        return false;
    }

    /**
     * 在BST树插入一个新的结点
     *
     * @param root
     * @param val
     * @return
     */
    TreeNode insertIntoBST(TreeNode root, int val) {

        //找到空白位置,插入
        if (root == null)
            return new TreeNode(val + "");

        //如果已经存在则直接返回
        if (Integer.parseInt(root.val) == val)
            return root;

        if (Integer.parseInt(root.val) > val)
            return insertIntoBST(root.left, val);

        if (Integer.parseInt(root.val) < val)
            return insertIntoBST(root.right, val);

        return root;
    }

    TreeNode deleteBSTNode(TreeNode root, int val) {

        //找到删除位置
        if (Integer.parseInt(root.val) == val) {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            //处理左右子树都存在的情况
            //找到最小的结点
            //去右子树找最小的结点
            //去左子树找最大的结点
            TreeNode minNode = getMin(root.right);

            root.val = minNode.val;

            //删除minNode结点
            root.right = deleteBSTNode(root.right, Integer.parseInt(minNode.val));


        } else if (Integer.parseInt(root.val) > val) {
            //去左子树上找
            root.left = deleteBSTNode(root.left, val);
        } else if (Integer.parseInt(root.val) < val) {
            //去右子树上去找
            root.right = deleteBSTNode(root.right, val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }


    public static void main(String[] args) {

    }
}
