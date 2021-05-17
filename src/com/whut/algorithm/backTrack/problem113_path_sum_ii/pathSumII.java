package com.whut.algorithm.backTrack.problem113_path_sum_ii;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/19 14:42
 * @desription
 */
public class pathSumII {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new LinkedList<>();

        List<Integer> path = new LinkedList<>();

        backTrack(root,sum,result,path);

//        for (LinkedList<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer +" ");
//            }
//            System.out.println();
//        }

        return result;

    }

    private static void backTrack(
            TreeNode root,
            int sum,
            List<List<Integer>> result,
            List<Integer> path
    ) {

        if (root == null)
            return;

        if (root.left == null && root.right == null && sum == root.val) {
            List<Integer> list = new LinkedList<>(path);
            list.add(root.val);
            result.add(list);
            return;
        }

        path.add(root.val);

        //遍历左子树
        backTrack(root.left, sum - root.val, result, path);

        backTrack(root.right, sum - root.val, result, path);

        path.remove(path.size() - 1);

    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);

        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);


        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);




        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println("-= = " + treeNode.left.left.left.val);

        pathSum(treeNode,22);


    }

}
