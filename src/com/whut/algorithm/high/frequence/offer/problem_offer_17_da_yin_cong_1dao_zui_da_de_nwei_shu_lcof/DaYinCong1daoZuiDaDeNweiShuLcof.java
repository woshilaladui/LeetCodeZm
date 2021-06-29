package com.whut.algorithm.high.frequence.offer.problem_offer_17_da_yin_cong_1dao_zui_da_de_nwei_shu_lcof;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/29 19:41
 * @desription
 */
public class DaYinCong1daoZuiDaDeNweiShuLcof {

    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder sb = new StringBuilder();

    public String printNumber(int len) {

        num = new char[len];
        for (int i = 1; i <= len; i++) {
            dfs(0, i);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public void dfs(int index, int len) {
        if (index == len) {
            sb.append(new String(num)).append(",");
            return;
        }
        int start = 0;
        //若从0作为起点：if(index == 0 && len>1)
        //若从1作为起点
        if (index == 0) {
            start = 1;
        }

        for (int i = start; i < 10; i++) {
            num[index] = loop[i];
            dfs(index + 1, len);
        }
    }

    public int[] printNumbers(int n) {
        if (n == 1)
            return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        String str = printNumber(n);

        System.out.println(str);

        String[] splits = str.trim().split(",");

        int[] result = new int[(int) Math.pow(10, n) - 1];



        for(int i = 0; i < result.length;i++){
            result[i] = Integer.parseInt(splits[i].trim());
        }

        return result;
    }

    public static void main(String[] args) {

//        String str = "1\u0000,2\u0000,3\u0000,4\u0000,5\u0000,6\u0000,7\u0000,8\u0000,9\u0000,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,991\u0000,2\u0000,3\u0000,4\u0000,5\u0000,6\u0000,7\u0000,8\u0000,9\u0000,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99";
//
//        String[] split = str.split(",");
//
//        for (String s : split) {
//            System.out.print(s+" ");
//        }


        DaYinCong1daoZuiDaDeNweiShuLcof daYinCong1daoZuiDaDeNweiShuLcof = new DaYinCong1daoZuiDaDeNweiShuLcof();


        //System.out.println(daYinCong1daoZuiDaDeNweiShuLcof.printNumber(2));

        int[] ints = daYinCong1daoZuiDaDeNweiShuLcof.printNumbers(2);

        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }

    }
}
