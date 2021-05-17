package com.whut.algorithm.high_frequence.tree.problem208_implement_trie_prefix_tree;

import com.whut.algorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/12 14:13
 * @desription
 */
public class ImplementTriePrefixTree {

    public static class Trie {


        private static class TrieNode {
            //当前字符
            private Character ch;
            //以当前结点到其他叶子结点的不同路径个数
            private int path;
            //以当前字符结尾的单词个数
            private int end;
            //表示当前字符能连接到的其他字符，最大26个 a-z
            private HashMap<Character, TrieNode> next;

            public TrieNode(Character ch) {
                this.path = 0;
                this.end = 0;
                this.ch = ch;
                this.next = new HashMap<>();
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            //初始化根结点
            root = new TrieNode('#');
        }

        /**
         * Inserts a word into the trie.
         */
        /**
         * 如同链表的生成过程一样，从根节点开始，如果根节点所连接的节点中没有当前字符，
         * 则生成一个值为当前字符的新节点，插入其中；如果有当前字符，则则继续进行匹配，
         * 并在过程中对每一个匹配到的节点path进行计数，重复上述过程，直到插完最后一个字符，
         * 并在最后一个字符的节点end进行计数，表示已经该单词的插入操作已经完成。
         *
         * @param word
         */
        public void insert(String word) {
            if (word == null || word.length() == 0)
                return;

            TrieNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                //如果没有该结点创建该结点，详情看图片数据结构

                char ch = word.charAt(i);

                if (!currentNode.next.containsKey(ch)) {
                    currentNode.next.put(ch, new TrieNode(ch));
                }

                currentNode = currentNode.next.get(ch);

                currentNode.path++;
            }
            currentNode.end++;
        }

        /**
         * 同insert操作基本相同，由于我这里使用的是Hashmap进行的节点存储，
         * 故如果在匹配的过程中没能匹配到，则表示搜索失败，匹配到后最后一个字符时，
         * 如果当前end值不为零，则表示匹配成功。
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0)
                return false;

            TrieNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!currentNode.next.containsKey(ch))
                    return false;

                currentNode = currentNode.next.get(ch);
            }

            if (currentNode.end == 0)
                return false;

            return true;
        }

        /**
         * 同search操作基本相同，只是这里判断到最后一个字符的时候，
         * 不需要判断end值。因为这里只需要检查前缀是否存在。
         */
        public boolean startsWith(String prefix) {

            if (prefix == null || prefix.length() == 0)
                return false;

            TrieNode currentNode = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (!currentNode.next.containsKey(ch))
                    return false;

                currentNode = currentNode.next.get(ch);
            }

            return true;
        }

        public void delete(String word) {

            int count = getWordCount(word);

            if (word == null || word.equals("") || !search(word))
                return;

            TrieNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if((currentNode.next.get(ch).path-=count) == 0){
                    //没有路径就删除该结点
                    currentNode.next.remove(ch);
                }
                currentNode = currentNode.next.get(ch);
            }

            currentNode.end-=count;
        }

        public int getWordCount(String word) {
            if (word == null || word.equals("") || !search(word))
                return 0;

            TrieNode currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                currentNode = currentNode.next.get(ch);
            }
            return currentNode.end;
        }
    }

    public static void main(String[] args) {

    }

}
