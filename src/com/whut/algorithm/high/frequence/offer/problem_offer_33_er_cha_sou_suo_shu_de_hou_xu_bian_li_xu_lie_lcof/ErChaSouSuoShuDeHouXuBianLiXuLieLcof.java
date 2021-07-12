package com.whut.algorithm.high.frequence.offer.problem_offer_33_er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/9 17:18
 * @desription
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return true; // 判空
        /*
         *  调用postOrder，
         *  初始start在数组最左边，即下标为0
         *  初始end在数组最右边，即下标为数组长度减一
         *  [start, end]是左闭右闭区间
         */
        return verifyPostorder(postorder, 0, postorder.length - 1);

    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        /*
         *  递归终止条件：
         *  start是数组最左边元素下标，end是数组最右边元素下标
         *  所以start >= end说明已经递归到只有一个节点(=)或没有节点(>)了
         *  返回真
         */
        if (start >= end) return true;

        int p = start; // 工作指针，初始为数组最左边
        int rootValue = postorder[end]; // 储存当前树的根节点的值


        /*
         *  若当前工作指针所指元素大于根节点值，
         *  说明为左子树节点
         *  工作指针右移
         */
        while (rootValue > postorder[p]) p++;

        /*
         *  上面循环结束时，工作指针指向的是不大于根节点值的节点
         *  即左子树结束节点为 p-1，右子树开始节点为p
         */
        int lfetTreeEnd = p - 1, rightTreeStart = p;

        /*
         *  若当前工作指针所指元素小于根节点值，
         *  说明为右子树节点
         *  工作指针右移
         */

        while (rootValue < postorder[p]) p++;

        /*
         * p != end 说明 rootValue < postorder[p] 中右节点有小于根结点的结点，这显然不可能
         *  上面循环结束时，工作指针指向第一个不小于根节点的节点
         *  若当前遍历的树是二叉搜索树，该工作指针p所指元素应该是end下标所指元素
         *  然后递归判断左子树和右子树，
         *  只有当左子树、右子树和当前整树都为二叉搜索树时，才返回真
         *  所以是&&
         *  （注意递归判断右子树时，右边界要end-1，去除原来树的根节点）
         */
        return p == end && verifyPostorder(postorder, start, lfetTreeEnd)
                && verifyPostorder(postorder, rightTreeStart, end - 1);


    }

    public static void main(String[] args) {

    }
}
