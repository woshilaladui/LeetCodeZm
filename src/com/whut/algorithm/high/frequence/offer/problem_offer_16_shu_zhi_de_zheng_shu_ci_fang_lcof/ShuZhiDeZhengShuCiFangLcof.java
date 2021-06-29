package com.whut.algorithm.high.frequence.offer.problem_offer_16_shu_zhi_de_zheng_shu_ci_fang_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/29 16:35
 * @desription
 */
public class ShuZhiDeZhengShuCiFangLcof {
    /**
     * 非递归快速幂
     * <p>
     * 每个二进制数位都有一个权值，权值如下图所示，最终结果就等于所有二进制位为1的权值之积，,
     * 例如上述 x^77次方对应的二进制 (1001101) 和每个二进制位的权值如下
     * 1	   0	   0	  1	     1	   0	  1
     * x^64	  x^32	  x^16	x^8	    x^4	   x^2	  x^1
     * <p>
     * 最终结果就是所有二进制位为1的权值之积：x^1 * x^4 * x^8 * x^64 = x^77
     * <p>
     * 计算出所有二进制位为1的数字
     * 77 >> 1
     * <p>
     * 0  1  0  0  1  1  0  这一位不计算
     * 0  0  0  0  0  0  1
     * <p>
     * 0  0  1  0  0  1  1
     * 0  0  0  0  0  0  1 & 1 ->  这一位要计算
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0)
            return 1;
        return n > 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    public double quickPow(double x, long n) {
        double result = 1.0;
        double contribute = x;

        while (n > 0) {
            //这一位需要计算
            if ((n & 1) == 1) {
                result *= contribute;
            }
            contribute *= contribute;

            n = n >> 1;
        }

        return result;
    }
}
