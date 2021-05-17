package com.whut.algorithm.high_frequence.problem148_sort_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/22 19:58
 * @desription
 */
public class SortList {

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

    public static ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    public static ListNode mergeSort(ListNode head, ListNode tail) {

        //[head,tail)

        if (head == null) {
            return null;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //寻找中点
        ListNode slow = head, fast = head;

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;

            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;

        /**
         * 开区间 链表题目都是是[left,right)
         */
        ListNode listNode1 = mergeSort(head, mid);
        ListNode listNode2 = mergeSort(mid, tail);

        return merge(listNode1, listNode2);

    }

    public static ListNode merge(ListNode head1, ListNode head2) {

        ListNode head = new ListNode(Integer.MAX_VALUE);

        ListNode p = head;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }

        if(head1 != null)
            p.next = head1;

        if(head2 != null)
            p.next = head2;

        return head.next;
    }


    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);

        listNode4.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = listNode3;

        ListNode listNode = sortList(listNode4);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
