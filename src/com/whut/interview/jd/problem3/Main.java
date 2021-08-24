package com.whut.interview.jd.problem3;

import com.whut.algorithm.high.frequence.dynamicPlaning.test.M;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 10:19
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Movie []movies = new Movie[4];

        for (int i = 0; i < N; i++) {
            movies[i] = preData(scanner.next());
        }
        System.out.println(getMaxTime(movies));
    }

    public static Movie preData(String time) {

        String[] times = time.split("-");
        String[] starts = times[0].split(":");
        String[] ends = times[1].split(":");
        int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
        int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]);
        return new Movie(start,end);
    }

    public static int getMaxTime(Movie[] movies) {

        int left = 0;
        int right = 0;
        int max = 0;
        int curentMax = 0;

        while (right < movies.length) {
            right++;
            //判断是否缩小
            if (right > 1 && movies[right-1].start < movies[right - 2].end) {
                left++;
            } else {
                if(right <=1){
                    curentMax = movies[0].end - movies[0].start;
                    continue;
                }

                curentMax += (  movies[right-2].end - movies[right-2].start);
            }

            if (right - left == 3) {
                max = curentMax;
                left++;
            }

        }

        return max;
    }

    public static class Movie {
        public int start;
        public int end;

        public Movie() {
        }

        public Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * 4
     * 10:00-10:30
     * 10:20-11:00
     * 11:00-11:30
     * 10:00-10:29
     */
}


