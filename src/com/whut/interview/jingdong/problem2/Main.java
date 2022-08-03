package com.whut.interview.jingdong.problem2;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/11 20:05
 * @desription
 */
public class Main {
    private static List<List<Integer>> openList = new ArrayList<>();
    private static List<Set<Integer>> closeList = new ArrayList<>();
    private static int[] visited;
    private static Set<Integer> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            openList.add(new ArrayList<>());
            closeList.add(new HashSet<>());
        }

        for (int i = 1; i < n + 1; i++) {
            int num = scanner.nextInt();

            for (int j = 0; j < num; j++) {
                openList.get(i).add(scanner.nextInt());
            }
            for (Integer integer : openList.get(i)) {
                closeList.get(integer).add(i);
            }
        }//end for

        for (int i = 0; i < q; i++) {
            int operation =  scanner.nextInt();
            int num = scanner.nextInt();
            Arrays.fill(visited,0);

            if(operation == 1){
                open(num);
            }else {
                close(num);
            }
            System.out.println(res.size());
        }

    }//end main

    private static void open(int num){
        if(visited[num] == 1)
            return;
        res.add(num);
        visited[num] = 1;
        for (Integer integer : openList.get(num)) {
            open(integer);
        }
    }

    private static void close(int num){
        if(visited[num] == 1)
            return;
        res.remove(num);
        visited[num] = 1;
        for (Integer integer : closeList.get(num)) {
            close(integer);
        }
    }
}
