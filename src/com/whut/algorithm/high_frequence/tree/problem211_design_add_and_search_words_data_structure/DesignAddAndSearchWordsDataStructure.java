package com.whut.algorithm.high_frequence.tree.problem211_design_add_and_search_words_data_structure;

import com.whut.algorithm.high_frequence.tree.problem208_implement_trie_prefix_tree.ImplementTriePrefixTree;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/23 15:17
 * @desription 类似208题目
 */
public class DesignAddAndSearchWordsDataStructure {

    static class WordDictionary {

        private static class TreeNode {
            //结点当前字符
            private Character ch;
            private int path;
            //以当前字符结尾的单词个数
            private int end;
            //表示当前字符能连接到的其他字符，最大26个 a-z
            private HashMap<Character, TreeNode> next;

            public TreeNode(Character ch) {
                this.ch = ch;
                this.path = 0;
                this.end = 0;
                this.next = new HashMap<>();
            }
        }

        private TreeNode root;


        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TreeNode('#');
        }

        public void addWord(String word) {
            if (word == null || word.length() == 0)
                return;

            TreeNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!currentNode.next.containsKey(c))
                    currentNode.next.put(c, new TreeNode(c));

                currentNode = currentNode.next.get(c);

                currentNode.path++;
            }
            currentNode.end++;
        }

        public boolean search(String word) {

            if (word == null || word.length() == 0)
                return false;

            return search(word, root);
        }

        public boolean search(String word, TreeNode root) {

            TreeNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (ch != '.') {
                    if (!currentNode.next.containsKey(ch))
                        return false;
                } else {
                    // c == '.'
                    //依次遍历a-z
                    for (char c = 'a'; c <= 'z'; c++) {
                        // 如果存在下一个字母，则从下一个字母开始再继续做检查
                        if (currentNode.next.get(c) != null) {
                            if (search(word.substring(i + 1), currentNode.next.get(c))) {
                                return true;
                            }
                        }
                    }//end for
                    //26个字母遍历完还没有找到说明不匹配
                    return false;
                }//end else
                currentNode = currentNode.next.get(ch);

            }

            if(currentNode.end == 0)
                return false;

            return true;
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("b.d"));
        System.out.println(wordDictionary.search("..d"));

    }
}
