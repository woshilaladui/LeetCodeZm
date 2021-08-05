package com.whut.algorithm.high.frequence.common.problem126_word_ladder_ii;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/25 16:55
 * @desription
 */
public class WordLadderII {


    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int count = 1;

        Queue<String> queue = new LinkedList<>();

        HashSet<String> wordSet = new HashSet<>();

        HashSet<String> visted = new HashSet<>();

        wordSet.addAll(wordList);
        //将第一个移除
        wordSet.remove(beginWord);

        //根结点
        queue.offer(beginWord);
        visted.add(beginWord);

        if(!wordList.contains(endWord))
            return 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String temp = queue.poll();

                char[] c_temp = temp.toCharArray();

                //挨个换字符
                for (int j = 0; j < c_temp.length; j++) {

                    char ch = c_temp[j];
                    //将这个字符转化为 a-z字符 看在不在wordSet中
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch)
                            continue;
                        //将j这个位置字符变成 c
                        c_temp[j] = c;

                        //将c_temp[j] ->string
                        String str = new String(c_temp);
                        //如果正好是endWord结束
                        if (str.equals(endWord)) {
                            visted.add(str);
                            return count + 1;
                        }

                        if (!visted.contains(str) && wordSet.contains(str)) {
                            queue.add(str);
                            visted.add(str);
                        }

                    }//end for
                    //还原
                    c_temp[j] = ch;
                }//end for

            }

            count++;
        }


        System.out.println(count);
        return visted.contains(endWord) ? count : 0;
    }

    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//
//        List<String> wordList = new ArrayList<>();
//
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        //wordList.add("cog");
//
//        System.out.println(ladderLength(beginWord, endWord, wordList));

        int a = Integer.MAX_VALUE;

        System.out.println(Math.pow(2,31)-1);

        System.out.println(a);

    }
}
