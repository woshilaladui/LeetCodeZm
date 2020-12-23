package com.whut.daily1;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/11 15:54
 * @desription
 */
public class Problem2 {

    /**
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     */

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){


        //两个都为空
        if(l1 == null && l2 == null)
            return null;

        //l1为空则返回l2
        /**
         * () + (5->6->4)
         *
         * 0 + 465 = 465
         *
         * (5->6->4)
         */
        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;


        //定义头结点来简化操作
        ListNode headNode = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = headNode;

        //进位标志
        int carry = 0;

        int numP1;
        int numP2;
        //每一位相加的和
        int sum = 0;

        while (p1 != null || p2 != null){

            numP1 = p1 != null ? p1.val : 0;
            numP2 = p2 != null ? p2.val : 0;

            sum = numP1 + numP2 + carry;

            //将累加的sum添加到新的结点上
            ListNode newNode = new ListNode(sum % 10);

            //计算进位
            carry = sum/10;

            //移动工作节点
            cur.next = newNode;
            cur = cur.next;

            //平移工作结点
            if(p1 != null)
                p1 = p1.next;

            if(p2 != null)
                p2 = p2.next;


        }//end while

        //判断最后一位是否有进位
        if(carry > 0)
            cur.next = new ListNode(carry);

        return headNode.next;
    }
}
