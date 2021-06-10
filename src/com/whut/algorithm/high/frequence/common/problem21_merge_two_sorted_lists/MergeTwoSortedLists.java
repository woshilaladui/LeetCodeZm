package com.whut.algorithm.high.frequence.common.problem21_merge_two_sorted_lists;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/12 20:04
 * @desription
 */
public class MergeTwoSortedLists {

    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);

        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";

        System.out.println(haystack.contains(needle));

    }
}
