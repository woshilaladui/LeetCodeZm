package com.whut.algorithm.high.frequence.offer.problem_offer_06_cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.ArrayList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/22 10:10
 * @desription
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    private void recur(ListNode head) {

        if(head == null)
            return;

        recur(head.next);

        list.add(head.val);

    }

    public static void main(String[] args) {

    }
}
