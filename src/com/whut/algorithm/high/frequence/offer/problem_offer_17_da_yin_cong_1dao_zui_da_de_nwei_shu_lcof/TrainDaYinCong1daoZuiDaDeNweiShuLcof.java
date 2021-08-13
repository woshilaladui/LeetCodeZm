package com.whut.algorithm.high.frequence.offer.problem_offer_17_da_yin_cong_1dao_zui_da_de_nwei_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/13 10:15
 * @desription
 */
public class TrainDaYinCong1daoZuiDaDeNweiShuLcof {

    char[] nums;
    int n;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder sb = new StringBuilder();

    public String printNumbers(int n) {
        this.n = n;

        nums = new char[n];

        dfs(0);
        sb.insert(0,0);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    private void dfs(int x) {
        if (x == n) {

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != '0')
                    sb.append(nums[i]);
            }
            sb.append(",");

            //sb.append(String.valueOf(nums)).append(",");
            return;
        }

        for (char c : loop) {
            nums[x] = c;
            dfs(x + 1);
        }

    }

    public static void main(String[] args) {
        TrainDaYinCong1daoZuiDaDeNweiShuLcof trainDaYinCong1daoZuiDaDeNweiShuLcof = new TrainDaYinCong1daoZuiDaDeNweiShuLcof();

        System.out.println(trainDaYinCong1daoZuiDaDeNweiShuLcof.printNumbers(3));
    }
}
