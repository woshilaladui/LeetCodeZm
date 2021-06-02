package com.whut.algorithm.high.frequence.problem_offer_32_cong_shang_dao_xia_da_yin_er_cha_shu_iii_lcof;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/19 10:14
 * @desription
 */
public class CongShangDaoXiaDaYinErChaShuIIILcof {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        queue.add(root);

        boolean isLeft = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode treeNode = queue.poll();

                if (isLeft) {
                    deque.addLast(treeNode.val);
                } else {
                    deque.addFirst(treeNode.val);
                }

                if (treeNode.left != null)
                    queue.offer(treeNode.left);

                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }

            result.add(new LinkedList<>(deque));
            isLeft = !isLeft;

        }
        return result;
    }

    public static void main(String[] args) {

//        Deque<Integer> deque = new ArrayDeque<>();
//
//        //deque.addFirst(1);
//        deque.addFirst(4);
//        deque.addFirst(5);
//        System.out.println();
//
//        while (!deque.isEmpty()){
//            System.out.println(deque.pollFirst());
//        }

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;

        treeNode3.right = treeNode5;


        List<List<Integer>> result = levelOrder(treeNode1);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

}
