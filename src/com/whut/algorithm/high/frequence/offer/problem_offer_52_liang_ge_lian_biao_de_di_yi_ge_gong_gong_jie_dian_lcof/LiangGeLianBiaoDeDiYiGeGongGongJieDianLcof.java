package com.whut.algorithm.high.frequence.offer.problem_offer_52_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/30 20:50
 * @desription
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    public static void main(String[] args) {

    }
}
