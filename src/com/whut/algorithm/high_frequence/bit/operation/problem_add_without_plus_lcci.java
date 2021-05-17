package com.whut.algorithm.high_frequence.bit.operation;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/13 10:55
 * @desription
 */
public class problem_add_without_plus_lcci {

    /**
     *
     * 思想：
     *  a ^ b -> 为 a + b 不考虑进位的结果
     *  (a & b) << 1 -> 位 a + b 进位的结果
     *  13 + 5
     *
     *  a & b 表示有进位
     *  carry =  (a & b) << 1
     *     1 1 0 1
     * &   0 1 0 1
     * --------------   代表 1 的位置有进制 (a & b)<<1  1010
     *     0 1 0 1
     *
     *  a ^ b
     *     1 1 0 1
     * ^   0 1 0 1
     * --------------
     *     1 0 0 0
     *
     * 当 carry + a^b没有进位的时候
     * a + b = carry ^ (a ^ b);
     * a + b = carry + a ^ b  -> 可能 carry + a ^ b也有进位
     * a = carry
     * b = a^b  再次循环
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        //当(a&b)!=0时，表示需要进位
        while ((a & b) != 0) {
            //a 存放进位信息
            int tmp = a;
            //(a&b)<<1表示进位信息
            a = (a & b) << 1;
            //b^tmp表示非进位操作
            b ^= tmp;
        }
        //退出while循环表示a,b之间不存在进位了，通过a^b求得结果
        return a ^ b;
    }

    public static void main(String[] args) {

        System.out.println(~10);
    }
}
