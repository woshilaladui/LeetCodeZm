package com.whut.interview.pdd.num2.problem4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 19:36
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int path = 1;
            for (int j = 1; j <= N; j++) {
                map.put(j, scanner.nextInt() - 1);
            }

            System.out.println(N);

            boolean flag = true;

//            while (flag) {
//                for (int j = 1; j <= N; j++) {
//                    if (j != N) {
//                        if (map.get(j) == 0)
//                            continue;
//                        else {
//                            if(map.get(j) >=1 ){
//                                path++;
//                            }
//                        }
//
//                    }
//                }//end for
//            }
        }


    }
}
