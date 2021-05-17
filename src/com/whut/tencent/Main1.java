package com.whut.tencent;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/21 21:29
 * @desription
 */
public class Main1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getPath(TreeNode root, int b) {

        Stack<TreeNode> stack = new Stack<>();

        Map<TreeNode, Integer> tag = new HashMap<>();

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

                //出栈结点正好是b的话，栈内就是结点到b的所有结点了
                if (stack.peek().val == b) {
                    ListNode head = new ListNode(-1);

                    head.next = null;

                    //头插法
                    while (!stack.empty()) {
                        ListNode p = new ListNode(stack.peek().val);

                        p.next = head.next;

                        head.next = p;
                        stack.pop();
                    }

                    return head.next;

                }
                stack.pop();
            }

            //沿着右分支
            if (!stack.empty()) {
                //标记该结点左结点访问过了
                tag.put(stack.peek(), 1);
                root = stack.peek().right;
            }
        }

        return null;
    }

    public static ListNode[] solve(TreeNode root, int[] b) {
        // write code here

        int n = b.length;

        ListNode []nodes = new ListNode[n];


        for(int i =0;i< n;i++){
            nodes[i] = getPath(root,b[i]);
        }


        return nodes;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        int []b = new int[]{1,2,3,4,5,6,7};


        solve(treeNode1,b);



    }

}
