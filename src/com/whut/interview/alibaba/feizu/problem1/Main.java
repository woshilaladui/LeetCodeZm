package com.whut.interview.alibaba.feizu.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/20 19:09
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        int n, k;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();

        Map<Integer, Boolean> map = new HashMap<>();

        //标记第一次能进入
        for (int i = 1; i <= n; i++) {
            map.put(i, true);
        }
        //5层
        int[] result = new int[5];
        for (int i = 0; i < n; i++) {
            int a, b, c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if (map.get(a)) {

                if (result[c - 1] < k) {
                    if (b == 1) {
                        ++result[c - 1];
                        //标记不能进入了
                        map.put(a,false);
                    }
                }//end if
            }else {
                //只能出去
                if(b == 0){
                    --result[c-1];
                }
            }

            for (int j = 0; j < 5; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }
}
/**
 * 4 3
 * 1 1 1
 * 2 1 1
 * 1 0 1
 * 1 1 2
 *
 * 5 2
 * 1 1 1
 * 2 1 1
 * 3 1 1
 * 4 1 1
 * 5 1 5
 *
 * 1 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 1
 *
 */
