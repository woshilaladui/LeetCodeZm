package com.whut.algorithm.tree;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/27 15:37
 * @desription
 */
public class Traverse {

    /**
     * 后续遍历tag标记
     *
     * @param root
     */
    private static void nonRecursionPostOrderTraverse2(TreeNode root) {


        if (root == null)
            return;
        Map<TreeNode, Integer> tag = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            //沿着左分支找
            while (root != null) {
                stack.push(root);
                //标记root左分支没有被访问过
                tag.put(root, 0);
                root = root.left;
            }

            //右分支被访问过了
            while (!stack.empty() && tag.get(stack.peek()) == 1) {
                System.out.println(stack.peek().val);
                stack.pop();
            }

            //沿着右分支
            if (!stack.empty()) {
                //标记该结点左结点访问过了
                tag.put(stack.peek(), 1);
                root = stack.peek().right;
            }
        }
    }

    //双栈

    /**
     * 后续遍历非递归
     *
     * @param tree
     */
    private static void nonRecursionPostOrderTraverse(TreeNode tree) {

        if (tree == null)
            return;
        else {
            /**
             * 原理就是将DRL 逆序输出为->LRD
             */
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stackTemp = new Stack<>();

            while (!stack.empty() || tree != null) {
                if (tree != null) {
                    //将根节点入栈，不访问
                    stack.push(tree);
                    stackTemp.push(tree);
                    //遍历左子树
                    //DRL->LRD
                    tree = tree.right;
                } else {
                    tree = stack.pop();
                    tree = tree.left;
                }
            }//end while

            while (!stackTemp.empty()) {
                TreeNode treeNode = stackTemp.pop();
                if (treeNode != null)
                    System.out.println(treeNode.val);
            }
        }
    }

    /**
     * 中序遍历非递归
     *
     * @param tree
     */
    private static void nonRecursionInOrderTraverse(TreeNode tree) {

        if (tree == null)
            return;
        else {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode preTree = null;

            //LDR
            while (!stack.empty() || tree != null) {
                if (tree != null) {
                    //当根节点不空时
                    stack.push(tree);
                    //LDR
                    tree = tree.left;
                } else {
                    if (preTree != null)
                        System.out.println("pre = " + preTree.val);
                    tree = stack.pop();
                    preTree = new TreeNode(tree.val);
                    System.out.println(tree.val);
                    tree = tree.right;
                }
            }

        }

    }

    /**
     * 前序遍历非递归
     *
     * @param tree
     */
    private static void nonRecursionPreOrderTraverse(TreeNode tree) {

        if (tree == null)
            return;

        else {
            Stack<TreeNode> stack = new Stack<>();
            //根节点入栈
            stack.push(tree);

            //当栈不空时
            while (!stack.empty()) {
                //DLR
                //访问根节点
                TreeNode tempNode = stack.pop();
                System.out.println(tempNode.val);

                //先将右子树入栈，再将左子树入栈
                if (tempNode.right != null)
                    stack.push(tempNode.right);
                if (tempNode.left != null)
                    stack.push(tempNode.left);

            }

        }

    }

    //Traverse

    /**
     * 前序遍历非递归
     *
     * @param tree
     */
    private static void nonRecursionPreOrderTraverse2(TreeNode tree) {

        if (tree == null)
            return;
        else {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || tree != null) {

                //DLR
                if (tree != null) {
                    //先访问根节点
                    System.out.println(tree.val);
                    //沿左分支找
                    stack.push(tree);
                    tree = tree.left;
                } else {
                    //出栈
                    tree = stack.pop();
                    tree = tree.right;
                }

            }
        }

    }

    /**
     * 层序遍历。
     *
     * @param tree
     */
    private static void levelTraverse(TreeNode tree) {
        if (tree == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        //根节点入队列
        queue.add(tree);

        while (!queue.isEmpty()) {
            //根节点出队列
            tree = queue.poll();
            System.out.println(tree.val);

            if (tree.left != null)
                queue.add(tree.left);
            if (tree.right != null)
                queue.add(tree.right);
        }
    }

    /**
     * 层序遍历统计树的高度
     *
     * @param root
     * @return
     */
    private static int treeDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        int depth = 0;

        //根节点入队列
        queue.offer(root);

        while (!queue.isEmpty()) {

            //sz用于统计该层的结点个数，用于来确保该层全部被访问到
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                //结点出队列
                TreeNode treeNode = queue.poll();

                //将左子树入队列
                if(treeNode.left != null)
                    queue.offer(treeNode.left);

                if(treeNode.right != null)
                    queue.offer(treeNode.right);

            }
            depth++;

        }


        return depth;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode("1");

        TreeNode treeNode2 = new TreeNode("2");

        TreeNode treeNode3 = new TreeNode("3");

        TreeNode treeNode4 = new TreeNode("4");

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;

        nonRecursionPostOrderTraverse2(treeNode1);

        System.out.println("depth = "+treeDepth(treeNode1));

    }

}
