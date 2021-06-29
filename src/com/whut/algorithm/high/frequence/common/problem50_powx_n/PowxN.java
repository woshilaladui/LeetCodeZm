package com.whut.algorithm.high.frequence.common.problem50_powx_n;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/8 19:23
 * @desription
 */
public class PowxN {

    /**
     * (a * b) % k = (a % k)(b % k) % k
     * <p>
     * 相当于对每个因子求模
     *
     * @return
     */
    int superPowMod(int a, int k, int base) {

        if (k == 0)
            return 1;

        //对每个因子求模
        a %= base;

        if (k % 2 == 1) {
            //奇数
            return (a * superPowMod(a, k - 1, base)) % base;
        } else {
            int sub = superPowMod(a, k / 2, base);
            return (sub * sub) % base;
        }
    }

    /**
     * 递归快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public static double quickMul(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double y = quickMul(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 非递归快速幂
     *
     *每个二进制数位都有一个权值，权值如下图所示，最终结果就等于所有二进制位为1的权值之积，,
     * 例如上述 x^77次方对应的二进制 (1001101) 和每个二进制位的权值如下
     * 1	   0	   0	  1	     1	   0	  1
     * x^64	  x^32	  x^16	x^8	    x^4	   x^2	  x^1
     *
     * 最终结果就是所有二进制位为1的权值之积：x^1 * x^4 * x^8 * x^64 = x^77
     *
     * 计算出所有二进制位为1的数字
     * 77 >> 1
     *
     * 0  1  0  0  1  1  0  这一位不计算
     * 0  0  0  0  0  0  1
     *
     * 0  0  1  0  0  1  1
     * 0  0  0  0  0  0  1 & 1 ->  这一位要计算
     * @param x
     * @param N
     * @return
     */
    public static double quickMu2(double x, long N) {
        double result = 1.0;
        double contribute = x;

        while (N > 0) {
            if ((N &1)  == 1) {
                result *= contribute;
            }
            contribute *= contribute;
            N = N >> 1;
        }

        return result;

    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMu2(x, N) : 1.0 / quickMul(x, -N);
    }


    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }
}
