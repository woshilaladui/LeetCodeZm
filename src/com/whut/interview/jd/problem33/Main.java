package com.whut.interview.jd.problem33;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 11:10
 * @desription
 */
public class Main {
    public static void main(String[] args) {

        Movie[] movies = new Movie[4];

        String[] str = new String[]{"10:00-10:30", "10:20-11:00", "11:00-11:30", "10:00-10:29"};

        for (int i = 0; i < 4; i++) {
            movies[i] = preData(str[i]);
        }

        int[][] dp = new int[4][4];

        //dp[0][0] = movies[0].end - movies[0].start;

        int max = 0;
        for(int i =0;i<4;i++){
            dp[1][i] = movies[i].end - movies[i].start;
        }

        for (int k = 1; k <= 3; k++) {
            for (int i =0; i < movies.length; i++) {

                if( i == 0){
                    if(k== 1)
                        dp[1][0] = movies[0].end - movies[0].start;
                    continue;
                }

                if (movies[i].start >= movies[i - 1].end) {
//                    if (k == 0) {
//                        dp[0][i] = movies[i].end - movies[i].start;
//                        continue;
//                    }


                    dp[k][i] = Math.max(dp[k - 1][i - 1] + movies[i].end - movies[i].start, dp[k][i]);

                    if(k == 3){
                        max = Math.max(dp[k][i],max);
                    }

                }
            }

        }

        System.out.println(max);
    }

    public static Movie preData(String time,String a){
        return null;
    }

    public final static Movie preData(String time) {

        String[] times = time.split("-");
        String[] starts = times[0].split(":");
        String[] ends = times[1].split(":");
        int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
        int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]);
        return new Movie(start, end);
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
}
