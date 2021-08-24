package com.whut.interview.aiqiyi.problem2.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 16:06
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.next();
            String[] arr = str.split(",");
            int idx = 0;
            int res = 0;

            while (idx < arr.length) {

                if (idx < arr.length - 1) {
                    int tem = Integer.valueOf(arr[idx]);

                    if (idx < arr.length - 1 && Integer.valueOf(arr[idx + 1]) <= tem) {
                        while (idx < arr.length - 1 && Integer.valueOf(arr[idx + 1]) <= Integer.valueOf(arr[idx])) {
                            idx++;
                        }
                    }

                    res = Math.max(Math.abs(Integer.valueOf(arr[idx]) - tem), res);
                    tem = Integer.valueOf(arr[idx]);

                    if (idx < arr.length - 1 && Integer.valueOf(arr[idx + 1]) >= tem) {
                        while (idx < arr.length - 1 && Integer.valueOf(arr[idx + 1]) >= Integer.valueOf(arr[idx])) {
                            idx++;
                        }
                    }//end if

                    res = Math.max(Math.abs(Integer.valueOf(arr[idx]) - tem), res);


                } else {
                    break;
                }

            }
            System.out.println(res);
        }
    }
}
