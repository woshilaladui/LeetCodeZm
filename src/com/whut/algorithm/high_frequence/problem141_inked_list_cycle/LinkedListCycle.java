package com.whut.algorithm.high_frequence.problem141_inked_list_cycle;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/22 15:01
 * @desription
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;


        while (slow != null){
            if(slow.next != null)
                slow = slow.next;
            else
                return false;
            if(fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                return false;

            if(slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode1;
       // listNode2.next = listNode3;
        //listNode3.next = listNode4;
       // listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));

    }
}
