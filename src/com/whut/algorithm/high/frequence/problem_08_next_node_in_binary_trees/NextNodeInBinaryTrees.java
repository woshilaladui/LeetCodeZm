package com.whut.algorithm.high.frequence.problem_08_next_node_in_binary_trees;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/23 9:13
 * @desription
 */
public class NextNodeInBinaryTrees {

    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(char x) {
            val = x;
        }
    }


    /**
     *
     * 思路：
     *
     * 1. 若该结点有右子树，右子树第一个结点就是该结点的下一个结点
     * 2. 若该结点没有右子树（并且它是父节点的左子树），则父节点就是他的下个结点
     * 3. 若该结点既没有右子树，并且它还它父节点的右子树，向上找到第一个是父节点的左节点，如果存在，说明父节点就是下一个结点
     *
     * @param root
     * @return
     */
    private static TreeNode getNextNode(TreeNode root){

        if(root == null)
            return null;

        TreeNode result = null;

        if(root.right != null){
            TreeNode treeNode = root.right;

            while (treeNode.left != null)
                treeNode = treeNode.left;

            result = treeNode;
        }else if(root.parent != null){
            /**
             *  2. 若该结点没有右子树（并且它是父节点的左子树），则父节点就是他的下个结点
             *  3. 若该结点既没有右子树，并且它还它父节点的右子树，向上找到第一个是父节点的左节点，如果存在，说明父节点就是下一个结点
             */

            TreeNode currentNode = root;
            TreeNode parentNode = root.parent;

            while (parentNode != null && currentNode == parentNode.right ){
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            result = parentNode;
        }
        return result;
    }


    public static void main(String[] args) {

        TreeNode treeNodea = new TreeNode('a');
        TreeNode treeNodeb = new TreeNode('b');
        TreeNode treeNodec = new TreeNode('c');
        TreeNode treeNoded = new TreeNode('d');
        TreeNode treeNodee = new TreeNode('e');
        TreeNode treeNodef = new TreeNode('f');
        TreeNode treeNodeg = new TreeNode('g');
        TreeNode treeNodeh = new TreeNode('h');
        TreeNode treeNodei = new TreeNode('i');

        treeNodea.left = treeNodeb;
        treeNodea.right = treeNodec;
        treeNodeb.parent = treeNodea;
        treeNodec.parent = treeNodea;

        treeNodeb.left = treeNoded;
        treeNodeb.right = treeNodee;
        treeNoded.parent = treeNodeb;
        treeNodee.parent = treeNodeb;

        treeNodec.left = treeNodef;
        treeNodee.right = treeNodeg;
        treeNodef.parent = treeNodec;
        treeNodeg.parent = treeNodec;

        treeNodee.left = treeNodeh;
        treeNodee.right = treeNodei;
        treeNodeh.parent = treeNodee;
        treeNodei.parent = treeNodee;


        System.out.println(getNextNode(treeNodei).val);
    }
}
