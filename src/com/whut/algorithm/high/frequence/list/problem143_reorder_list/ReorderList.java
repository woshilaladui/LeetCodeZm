package com.whut.algorithm.high.frequence.list.problem143_reorder_list;

import com.whut.algorithm.high.frequence.tree.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/18 11:06
 * @desription
 */
public class ReorderList {

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

    public static void reorderList1(ListNode head) {

        List<ListNode> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;

        while (i < j) {

            list.get(i).next = list.get(j);
            i++;

            if (i == j)
                break;

            list.get(j).next = list.get(i);
            j--;
        }
        //处理最后一个节点
        list.get(i).next = null;
    }

    public static void reorderList2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
            }
        }

        ListNode temp1 = head;
        ListNode temp2 = reverse1(slow.next);
        slow.next = null;

        mergeList(temp1,temp2);

    }

    private static void mergeList(ListNode l1, ListNode l2) {

        ListNode nxtL1;
        ListNode nxtL2;
        while (l1 != null && l2 != null) {
            nxtL1 = l1.next;
            nxtL2 = l2.next;

            l1.next = l2;
            l1 = nxtL1;

            l2.next = l1;
            l2 = nxtL2;
        }

    }


    private static ListNode reverse1(ListNode head){

        ListNode cur = head;
        ListNode nxt = head;
        ListNode pre = null;

        while (cur != null){
            //防止断链
            nxt = cur.next;

            //翻转
            cur.next = pre;

            //更新
            pre = cur;
            cur = nxt;

        }

        return pre;
    }

    /**
     *
     * @param head
     * @return
     */
    private static ListNode reverse2(ListNode head){

       if(head == null || head.next == null)
           return head;


       ListNode last = reverse2(head.next);

       //翻转
        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
      //  ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
    //    listNode4.next = listNode5;

        reorderList2(listNode1);

        while (listNode1 != null){
            System.out.print(listNode1.val+" ");
            listNode1 = listNode1.next;
        }
    }
}
