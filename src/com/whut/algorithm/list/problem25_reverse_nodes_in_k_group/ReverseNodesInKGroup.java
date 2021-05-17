package com.whut.algorithm.list.problem25_reverse_nodes_in_k_group;

import com.whut.algorithm.list.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/14 17:21
 * @desription
 */
public class ReverseNodesInKGroup {

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

    /**
     * 反转[a,b]区间的链表
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverse2(ListNode a, ListNode b){
        ListNode pre,cur,nxt;
        pre = null;
        cur = a;
        nxt = a;

        while (cur != b){
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;

        //反转[a,b]
        ListNode a, b;
        a = b = head;

        for(int i = 0;i<k;i++){
            //不足k个不需要反转
            if(b == null)
                return head;

            b = b.next;
        }

        //反转前k个元素
        ListNode newHead = reverse2(a,b);

        //递归反转后将链表连接起来
        a.next = reverseKGroup(b,k);

        return newHead;
    }

    public static void main(String[] args) {

    }
}
