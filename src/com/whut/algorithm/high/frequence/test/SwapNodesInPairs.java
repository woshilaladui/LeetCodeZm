package com.whut.algorithm.high.frequence.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 15:55
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


        /**
         *
         * 1-2-3-4
         *
         * a->1
         * b->2
         *
         * reverse后
         *
         * 2-1-3-4
         *
         */
        ListNode newHead = reverseAB(a, b);

        a.next = swapPairs(b);

        return newHead;
    }

    /**
     * @param a
     * @param b
     * @return [a, b) 之间翻转
     */
    public static ListNode reverseAB(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode nxt = a;
        ListNode pre = null;

        while (cur != b) {
            nxt = cur.next;

            //翻转
            cur.next = pre;
            pre = cur;
            cur = nxt;

        }
        //返回新的头节点
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
