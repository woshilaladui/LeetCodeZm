package com.whut.algorithm.pdd.problem3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/25 19:17
 * @desription
 */
public class Problem3 {


    private void backTrack(List<Integer> result, List<Integer> path,
                           int A, int B, int C, int Q) {

        if (!path.isEmpty() && path.get(path.size() - 1) == Q) {
            result.add(99999);
        } else if (!path.isEmpty() && path.get(path.size() - 1) > Q)
            return;
        else if (!path.isEmpty() && path.get(path.size() - 1) < Q)
            result.add(path.get(path.size() - 1));

        for (int i = 0; i < result.size(); i++) {

            if (path.contains(result.get(i) + B))
                continue;
            path.add(result.get(i) + B);

            backTrack(result, path, A, B, C, Q);
            if (result.contains(99999))
                return;
            path.remove(path.size() - 1);


            if (path.contains(result.get(i) * C))
                continue;
            path.add(result.get(i) * C);
            backTrack(result, path, A, B, C, Q);
            if (result.contains(99999))
                return;
            path.remove(path.size() - 1);

        }


    }

    private int Main() {

        List<Integer> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        int A, B, C, Q, N;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        for (int i = 0; i < N; i++) {

            A = in.nextInt();
            B = in.nextInt();
            C = in.nextInt();
            Q = in.nextInt();

            result.add(A);
            backTrack(result, path, A, B, C, Q);

            if (result.contains(99999))
                System.out.println(1);
            else
                System.out.println(0);
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();

        problem3.Main();
    }
}
