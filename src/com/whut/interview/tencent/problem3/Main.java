package com.whut.interview.tencent.problem3;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 21:51
 * @desription
 */
public class Main {

    boolean[] vis;
    int MN;

    void dfs(int[] p, int num, int w, int n, int sum, int count) {
        if (sum >= MN) {
            return;
        }
        if (count == 0) {
            if (sum == 0) {
                MN = Math.min(num - 1, MN);
            } else {
                MN = Math.min(num, MN);
            }
            return;
        }//end if

        for (int i = 0; i < p.length; i++) {
            if(!vis[i] && sum +p[i]<=w && n>=1){
                if(n ==2){
                    vis[i] = true;
                    dfs(p,num,w,n-1,p[i],count-1);
                   // vis[i] =
                }
            }
        }


    }

    public static void main(String[] args) {

    }
}
