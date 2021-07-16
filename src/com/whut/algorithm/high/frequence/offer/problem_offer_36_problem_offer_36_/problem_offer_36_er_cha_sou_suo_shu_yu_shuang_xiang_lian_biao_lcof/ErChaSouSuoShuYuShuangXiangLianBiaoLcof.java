package com.whut.algorithm.high.frequence.offer.problem_offer_36_problem_offer_36_.problem_offer_36_er_cha_sou_suo_shu_yu_shuang_xiang_lian_biao_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/16 9:32
 * @desription
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {


    class Node {
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

    private Node pre,head;

    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;

        inOrderTraverse(root);

        //处理最后结点
        head.left = pre;
        pre.right = head;

        return head;
    }

    public void inOrderTraverse(Node cur){

        if(cur == null)
            return;

        inOrderTraverse(cur.left);

        if(pre != null)
            //后继
            pre.right = cur;
        else
            //头节点
            head = cur;

        //前驱
        cur.left = pre;
        pre = cur;

        inOrderTraverse(cur.right);
    }




    public static void main(String[] args) {

    }
}
