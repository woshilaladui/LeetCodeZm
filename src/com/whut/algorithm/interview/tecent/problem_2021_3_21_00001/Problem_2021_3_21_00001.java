package com.whut.algorithm.interview.tecent.problem_2021_3_21_00001;

import java.util.*;

/**
 *
 * 思想参考leetcode 23
 *
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/24 16:42
 * @desription
 */
public class Problem_2021_3_21_00001 {

    private static Map<Integer, int[]> map = new HashMap<>();

    private static int getK(int []questionArr,int k) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : questionArr) {
            int []arr = map.get(i);
            for (int node : arr) {
                queue.offer(node);
            }
        }

        int result = 0;

        while (k > 0 && !queue.isEmpty()){
            result = queue.poll();
            k--;
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        //n个数组
        for (int i = 1; i <= n; i++) {
            int m_i = scanner.nextInt();
            int[] arr = new int[m_i];
            for (int j = 0; j < m_i; j++)
                arr[j] = scanner.nextInt();

            Arrays.sort(arr);

            map.put(i, arr);
        }//end for

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int p_i = scanner.nextInt();
            int []questionArr = new int[p_i];
            for(int j = 0;j < p_i;j++){
                questionArr[j] = scanner.nextInt();
            }

            int k = scanner.nextInt();

            System.out.println(getK(questionArr,k));


        }
    }
}
