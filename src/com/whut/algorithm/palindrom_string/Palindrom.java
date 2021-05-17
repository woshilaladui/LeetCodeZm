package com.whut.algorithm.palindrom_string;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 18:53
 * @desription
 */
public class Palindrom {

    public static class ListNode {
        public ListNode next;
        public int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

    private static ListNode reverse(ListNode head) {

        if (head.next == null)
            return head;

        //p为工作结点，r为防止断链
        ListNode p, r;
        //定义头结点
        ListNode L = new ListNode(0);

        p = head;
        L.next = null;
        while (p != null) {
            r = p.next;
            ListNode pnew = new ListNode(p.val);
            pnew.next = L.next;
            //p.next = L.next;
            L.next = pnew;
            p = r;
        }

        System.out.println("head = " + L.next.val);
        return L.next;
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = reverse(head);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r - l - 1);
    }

    public static void main(String[] args) {

//        String s = "abcddcbadftgh";
//        System.out.println(palindrome(s,0,s.length()-1));

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        //traverse(listNode1);

//        listNode1 = reverse(listNode1);
//        System.out.println(listNode1.val);

        System.out.println(isPalindrome(listNode1));

    }

    public static void traverse(ListNode head) {
        if (head == null) return;
        traverse(head.next);
        // 后序遍历代码
        System.out.println(head.val);
    }


}
