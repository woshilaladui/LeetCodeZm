package com.whut.algorithm.high_frequence.problem_offer_36_er_cha_sou_suo_shu_yu_shuang_xiang_lian_biao_lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/21 9:37
 * @desription
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static Node treeToDoublyList(Node root) {

        List<Node> list = new ArrayList<>();

        if (root == null)
            return null;
        else {
            Stack<Node> stack = new Stack<>();

            while (!stack.empty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root);
                    root = root.right;
                }
            }

        }

        int n = list.size();

        if(n == 1){
            list.get(0).left = list.get(0);
            list.get(0).right = list.get(0);
            return list.get(0);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.get(i).left = list.get(n - 1);
                list.get(i).right = list.get(i + 1);
            } else if (i == n - 1) {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(0);
            } else {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(i + 1);
            }
        }


        return list.get(0);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//
//        node4.left = node2;
//        node4.right = node5;
//
//        node2.left = node1;
//        node2.right = node3;
//
//        Node node = treeToDoublyList(node1);
//
//        for (int i = 0; i < 6; i++) {
//            System.out.println(node.val);
//            node = node.right;
//        }


        System.out.println(2^3);

    }
}
