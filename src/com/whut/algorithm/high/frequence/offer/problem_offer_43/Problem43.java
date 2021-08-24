package com.whut.algorithm.high.frequence.offer.problem_offer_43;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/27 10:03
 * @desription
 */
public class Problem43 {

    public static void main(String[] args) {
        System.out.println(123%10);
//        Date date = new Date();
//
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Date date1 = new Date();
//
//        System.out.println((date1.getTime()-date.getTime())/1000 );
        System.out.println(countDigitOne(123));
    }

    public static int countDigitOne(int n) {
        //高位
        int high = n;
        //低位
        int low = 0;
        //当前位
        int cur = 0;
        int count = 0;
        int num = 1;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high /= 10;
            //这里我们可以提出 high * num 因为我们发现无论为几，都含有它
            if (cur == 0) count += high * num;
            else if (cur == 1) count += high * num + 1 + low;
            else count += (high + 1) * num;
            //低位
            low = cur * num + low;
            num *= 10;
        }
        return count;

    }
}
