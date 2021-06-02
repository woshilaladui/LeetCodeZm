package com.whut.algorithm.high.frequence.list.problem234_palindrome_linked_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/30 14:59
 * @desription
 */
public class PalindromeLinkedList {

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

    //返回链表中间结点
    public ListNode halfOfList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode firstHalfEnd = halfOfList(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        //p2要短点
        while (p2 != null) {
            if(p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //last为翻转链表的头结点
        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args) {

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println();

        System.out.println(palindromeLinkedList.isPalindrome(listNode1));

    }
}
