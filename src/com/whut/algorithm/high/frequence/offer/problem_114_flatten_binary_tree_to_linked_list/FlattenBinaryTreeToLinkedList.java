package com.whut.algorithm.high.frequence.offer.problem_114_flatten_binary_tree_to_linked_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/12 9:20
 * @desription
 */
public class FlattenBinaryTreeToLinkedList {

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

    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null){
            //遍历左子树
            while (cur.left != null){
                TreeNode next = cur.left;
                TreeNode pre = next;

                //寻找该结点的最右结点，该结点是cur结点访问的左子树的最后结点
                while (pre.right != null){
                    pre = pre.right;
                }


                pre.right = cur.right;

                cur.left = null;

                //更新结点
                cur.right = next;

            }

            //更新结点,因为更新成了右节
            cur = cur.right;
        }
    }


    public static void main(String[] args) {
    }
}
