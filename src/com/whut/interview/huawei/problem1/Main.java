package com.whut.interview.huawei.problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/1 19:18
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k,a;
        k = scanner.nextInt();
        String []arr = new String[k];

        int[] arrM = new int[k];
        int[] arrN = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.next();
            String[] split = arr[i].split(",");
            arrM[i] = Integer.parseInt(split[0]);
            arrN[i] = Integer.parseInt(split[1]);
//            arrM[i] = scanner.nextInt();
//            arrN[i] = scanner.nextInt();
        }
        a = scanner.nextInt();
        System.out.println(getMinPoint(k,arrM,arrN,a));

    }

    private static int getMinPoint(int k, int[] arrM, int[] arrN,int a) {
        if (k == 1)
            return a > arrM[0] + arrN[0] ?  arrM[0] + arrN[0] : a;
        if (k == 2) {
            int temp1 = arrM[0] + arrN[0];
            int temp2 = arrM[1] + arrN[1];
            int temp3 = Math.min(temp1,temp2);
            return a > temp3 ? temp3 : a;
        }
//        Arrays.sort(arrM);
//        Arrays.sort(arrN);
        sort(arrM,arrN);

//        int temp1 = arrM[0] + arrN[0];
//        int result = 0;
//        if(a > arrM[1] + arrN[1]){
//            result = arrM[0];
//            if(arrN[1] < arrM[0])
//                result += arrN[1];
//            else
//                result += arrN[0];
//        }else {
//
//        }

//        return result;

        return a > arrM[0] + arrN[0] ? arrM[0] + arrN[0] : a;
    }

    private static void sort(int[] arrM, int[] arrN){
        int n = arrN.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arrM[j - 1] > arrM[j]) {
                    int temp = arrM[j - 1];
                    arrM[j - 1] = arrM[j];
                    arrM[j] = temp;

                    temp = arrN[j-1];
                    arrN[j-1] = arrN[j];
                    arrN[j] = temp;
                }
            }
        }//end for
    }
}
