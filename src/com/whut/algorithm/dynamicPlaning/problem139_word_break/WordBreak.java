package com.whut.algorithm.dynamicPlaning.problem139_word_break;

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

    public static void main(String[] args) {


        String s = "catsandog";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(wordBreak(s,wordDict));

    }

}
