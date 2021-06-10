package com.whut.algorithm.high.frequence.dynamicPlaning.problem139_word_break;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/25 14:29
 * @desription
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        /**
         * dp[i] 代表s.substring(0,i)之间的字符串 能否由字典里面的单词组成
         */
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {

            //将其理解成为装电池的操作
            for (String word : wordDict) {

                //能放进去
                if (word.length() <= i && dp[i - word.length()]) {
                    if (s.substring(i - word.length(), i).equals(word))
                        dp[i] = true;
                }

            }//end for

        }//end for


        return dp[s.length()];

    }

    public static boolean wordBreak2(String s, List<String> wordDict) {

        int n = s.length();

        //代表s.subString(0,i)之间能否由字典组成
        boolean[] dp = new boolean[n];

        //base case
        dp[0] = true;

        /**
         * 想象成装电池的操作
         *
         * eg:"applepenapple", wordDict = ["apple", "pen"]
         *
         * 想象成一个装电池的操作，i作为指针从0到n,当能放下电池时候，去判断能否放入
         * 电池组内的电池
         *
         */

        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                //装的下电池并且要是吻合的电池
                if(word.length() <=i && dp[i-word.length()])
                    //电池能装下时检查电池是否符合要求
                    if(s.substring(i-word.length(),i).equals(word))
                        dp[i] = true;

            }
        }


        return dp[n-1];
    }

    public static void main(String[] args) {


        String s = "catsandog";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(wordBreak(s, wordDict));

    }

}
