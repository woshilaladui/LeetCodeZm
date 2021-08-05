package com.whut.algorithm.high.frequence.common.problem19_remove_nth_node_from_end_of_list;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/1 20:52
 * @desription
 */
public class RemoveNthNodeFromEndOfList {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        if(head.next == null)
            return null;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode treeNode1 = new ListNode(1);
        ListNode treeNode2 = new ListNode(2);
        ListNode treeNode3 = new ListNode(3);
        ListNode treeNode4 = new ListNode(4);
        ListNode treeNode5 = new ListNode(5);

        treeNode1.next = treeNode2;
//        treeNode2.next = treeNode3;
//        treeNode3.next = treeNode4;
//        treeNode4.next = treeNode5;

        removeNthFromEnd(treeNode1, 2);

        while (treeNode1 != null) {
            System.out.println(treeNode1.val);
            treeNode1 = treeNode1.next;
        }

    }
}
