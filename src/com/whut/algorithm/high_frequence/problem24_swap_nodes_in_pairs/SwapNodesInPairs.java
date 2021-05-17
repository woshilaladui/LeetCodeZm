package com.whut.algorithm.high_frequence.problem24_swap_nodes_in_pairs;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/16 20:58
 * @desription
 */


public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;
        while (cur != b) {
            nxt = cur.next;

            //翻转
            cur.next = pre;
            pre = cur;
            cur = nxt;

        }
        return pre;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode a, b;
        a = b = head;

        for (int i = 0; i < 2; i++) {
            if (b == null)
                return head;
            b = b.next;
        }

        ListNode newHead = reverse(a, b);

        a.next = swapPairs(b);

        return newHead;
    }


    public static ListNode reverse2(ListNode a){

        ListNode L = new ListNode(0);


        return null;
    }

    public static ListNode reverse(ListNode a){

        //不带头结点
        ListNode pre,nxt,cur;
        cur = a;
        pre = null;

        while (cur !=null){
            nxt = cur.next;

            //翻转
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        //listNode4.next = listNode5;

        //listNode1.next = reverse(listNode1,listNode3);

        ListNode temp = swapPairs(listNode1);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }




    }
}
