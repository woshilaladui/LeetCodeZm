package com.whut.algorithm.high.frequence.dynamicPlaning.rob.problem337_house_robber_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/3 15:26
 * @desription
 */
public class HouseRobberII {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //后续遍历来解问题

    /**
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     *
     * @param root
     * @return
     */
    private static int[] dp(TreeNode root) {

        if (root == null)
            return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        //后续遍历处理问题
        //偷根节点则子节点不能抢
        int rob = root.val + left[0] + right[0];
        //可以抢下一家
        //左边抢和不抢的最大值 + 右边抢和不抢的最大值
        int no_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{no_rob,rob};
    }


    private static int rob(TreeNode root) {

        int[] res = dp(root);

        return Math.max(res[0],res[1]);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = null;
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = null;
        treeNode.right.right = new TreeNode(1);

        System.out.println(rob(treeNode));

    }

}
