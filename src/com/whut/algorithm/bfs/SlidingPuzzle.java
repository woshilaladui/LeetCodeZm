package com.whut.algorithm.bfs;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/2 15:03
 * @desription
 */
public class SlidingPuzzle {


    private static int slidingPuzzle(int[][] board) {

        int m = 3, n = 2;
        String start = "";
        String target = "123450";

        //将2*3的数组转化为字符串
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                start += board[i][j];
            }
        }


        System.out.println(start);

        List<List<Integer>> neighbor = new ArrayList<>();
        neighbor.add(Arrays.asList(1, 3));
        neighbor.add(Arrays.asList(0, 4, 2));
        neighbor.add(Arrays.asList(1, 5));
        neighbor.add(Arrays.asList(0, 4));
        neighbor.add(Arrays.asList(3, 1, 5));
        neighbor.add(Arrays.asList(4, 2));

        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        int step = 0;


        //初始化
        //根节点入队列
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            int sz = queue.size();

            //控制当前层被访问完
            for (int i = 0; i < sz; i++) {
                //队头出队列
                String cur = queue.poll();
                char[] c_cur = cur.toCharArray();

                if (cur.equals(target))
                    return step;

                //找到0的位置
                int idx = 0;
                for (; c_cur[idx] != '0'; idx++) ;

                //遍历上下左右
                for (int adj : neighbor.get(idx)) {
                    //注意要重置，也就是要还原
                    char[] c_new_board = cur.toCharArray();

                    char temp;
                    temp = c_new_board[adj];
                    c_new_board[adj] = c_new_board[idx];
                    c_new_board[idx] = temp;

                    String new_board = new String(c_new_board);

                    System.out.println("new_board = " + new_board);

                    //防止重复
                    if (!visited.contains(new_board)) {
                        queue.offer(new_board);
                        visited.add(new_board);
                    }


                }


            }
            step++;
        }


        return -1;
    }

    public static void main(String[] args) {
//        int[][] board = new int[][]{{2,4,1}, {5, 0, 3}};
//        System.out.println(slidingPuzzle(board));
//
//        int []a = new int[]{1,2,3};
//
//        System.out.println(Arrays.stream(a).sum());

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int i;
        int tempL = L;
        boolean flag = false;

        System.out.println(0%10);

        while(tempL <= 100){
            if(((2*N + tempL - tempL * tempL) % (2 * tempL)) == 0){
                int a1 = (2*N + tempL - tempL * tempL) / (2 * tempL);

                flag = true;
                for( i = 0;i < tempL -1 ; i++){
                    System.out.print(a1+i+" ");
                }
                System.out.println(a1+i);
                break;

            }
            else{
                tempL++;
            }

        }
        if(!flag)
            System.out.println("No");

    }

}
