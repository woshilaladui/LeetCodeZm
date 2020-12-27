package com.whut.algorithm.tree.problem99_recover_binary_search_tree;


import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/27 16:54
 * @desription
 */
public class RecoverBinarySearchTree {

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


    private static void nonRecursionInOrderTraverse(TreeNode root) {

        if (root == null)
            return;
        else {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode preTree = new TreeNode(Integer.MIN_VALUE);

            TreeNode p1 = null,p2 = null;

            //LDR
            while (!stack.empty() || root != null) {
                if (root != null) {
                    //当根节点不空时
                    stack.push(root);
                    //LDR
                    root = root.left;
                } else {

                    root = stack.pop();
                    if (preTree != null) {
                        if (preTree.val > root.val) {
                            //最后交换
                            if(p1 == null){
                                p1 = preTree;
                                p2 = root;
                            }else {
                                p2 = root;
                            }
                        }
                    }//end if
//
                    preTree = root;
                    root = root.right;
                }
            }//end while

            //交换p1,p2
            int temp = p2.val;
            p2.val = p1.val;
            p1.val = temp;

        }

    }

    private static void swapTree(TreeNode pre, TreeNode root) {


        int temp = root.val;

        root.val = pre.val;
        pre.val = temp;

    }


    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);

//        treeNode3.left = treeNode1;
//        treeNode3.right = treeNode4;
//
//        treeNode4.left = treeNode2;

        treeNode1.left = treeNode3;
        treeNode3.right = treeNode2;

        System.out.println(treeNode1.val);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode3.right.val);
//
//        System.out.println("**************************");

        nonRecursionInOrderTraverse(treeNode1);

        System.out.println(treeNode1.val);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode3.right.val);

    }
}
