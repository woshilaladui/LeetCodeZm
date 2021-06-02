package com.whut.algorithm.high.frequence.tree.problem236_lowest_common_ancestor_of_a_binary_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/29 20:25
 * @desription
 */
public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(TreeNode treeNode) {
            val = treeNode.val;
        }
    }

    //相当于tag标记的后序遍历
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        TreeNode tempRoot = root;


        //用于标记该结点的左子树是访问过了
        Map<TreeNode, Integer> tag = new HashMap<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root != null || !stack1.isEmpty()) {

            //沿左分支找
            while (root != null) {
                stack1.push(root);
                tag.put(root, 0);
                root = root.left;
            }

            //出栈访问
            //判断栈顶结点的左子树是否访问
            while (!stack1.isEmpty() && tag.get(stack1.peek()) == 1) {
                //System.out.println(stack1.peek().val);
                if (stack1.peek() == p) {

                    //System.out.println("pekk = " + stack1.peek().val);
                    //将其复制到stack2中
                    stack2.addAll(stack1);
                }

                if (stack1.peek() == q) {
                    //对比stack1和stack2第一个相同的就是公共父节点

                    for (int i = stack1.size() - 1; i >= 0; i--) {
                        for (int j = stack2.size() - 1; j >= 0; j--) {
                            if (stack1.get(i) == stack2.get(j))
                                return stack2.get(j);

                        }
                    }

                }
                //栈顶出栈
                stack1.pop();

            }//end while

            if (!stack1.isEmpty()) {
                //访问左分支
                tag.put(stack1.peek(), 1);
                root = stack1.peek().right;
            }

        }


        //相当于先访问q再p，上述代码必须保证先访问p再q，走到这里说明先访问了q，只要交换一下顺序即可
        return lowestCommonAncestor(tempRoot, q, p);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;

        return left == null ? right : left;
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

        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        //TreeNode result = lowestCommonAncestor(treeNode3, treeNode4, treeNode5);

        TreeNode result = lowestCommonAncestor2(treeNode3, treeNode4, treeNode5);


        System.out.println(result.val);

    }
}
