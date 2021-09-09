package com.whut.algorithm.high.frequence.common.problem437_path_sum_iii;

import java.util.*;

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
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        return backTrack(root,prefixMap,targetSum,0);
    }

    private int backTrack(
            TreeNode node,
            Map<Integer, Integer> prefixMap,
            int target,
            int curSum
    ) {
        if (node == null) {
            return 0;
        }
        //本层结果
        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - target, 0);
        //保存当前结点的前缀和
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        res += backTrack(node.left, prefixMap, target, curSum);
        res += backTrack(node.right, prefixMap, target, curSum);

        //递归结束清除上一层的前缀和
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        return res;

    }

}
