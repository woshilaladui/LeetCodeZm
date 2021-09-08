package com.whut.algorithm.high.frequence.common.problem437_path_sum_iii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 21:12
 * @desription
 */
public class PathSumIii {

    public class TreeNode {
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

    public int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backTrack(result,path,targetSum,root);
        return result.size();
    }

    private static void backTrack(
            List<List<Integer>> result,
            List<Integer> path,
            int sum,
            TreeNode root
    ) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> list = new LinkedList<>(path);
            path.add(root.val);
            result.add(list);
            return;
        }

        path.add(root.val);
        backTrack(result,path,sum - root.val,root.left);
        backTrack(result,path,sum - root.val,root.right);
        path.remove(path.size()-1);
    }
}
