//package com.whut.algorithm.high_frequence.tree.problem208_implement_trie_prefix_tree;
//
//import java.util.HashMap;
//
///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/5/12 10:26
// * @desription
// */
//public class ImplementTriePrefixTreeTest {
//
//
//    public static class Trie {
//        public class TrieNode {
//            //当前字符连接路径个数
//            public int path;
//            //以当前字符结尾的字符个数
//            public int end;
//            //当前字符
//            public Character ch;
//            public HashMap<Character, TrieNode> next;
//
//            public TrieNode(char ch) {
//                path = 0;
//                end = 0;
//                next = new HashMap<>();
//                this.ch = ch;
//            }
//        }
//
//        private TrieNode root;
//
//        public Trie() {
//            root = new TrieNode('#');
//        }
//
//        public void insert(String word) {
//            if (word == null || word.equals("")) return;
//            TrieNode node = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (!node.next.containsKey(ch)) {
//                    node.next.put(ch, new TrieNode(ch));
//                }
//                node = node.next.get(ch);
//                node.path++;
//            }
//            node.end++;
//        }
//
//        public boolean search(String word) {
//            if (word == null || word.equals("")) return false;
//            TrieNode node = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (!node.next.containsKey(ch)) return false;
//                node = node.next.get(ch);
//            }
//            if (node.end == 0) return false;
//            return true;
//        }
//
//        public boolean startsWith(String word) {
//            if (word == null || word.equals("")) return false;
//            TrieNode node = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (!node.next.containsKey(ch)) return false;
//                node = node.next.get(ch);
//            }
//            return true;
//        }
//
//        public int getWordCount(String word) {
//
//            if (word == null || word.equals("") || !search(word)) return -1;
//
//            TrieNode node = root;
//
//            for (int i = 0; i < word.length(); i++)
//                node = node.next.get(word.charAt(i));
//
//            return node.end;
//        }
//
//        public void delete(String word, int count) {
//            if (word == null || word.equals("") || !search(word)) return;
//            TrieNode node = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//
//                if ((node.next.get(ch).path -= count) == 0) {
//                    node.next.remove(ch);
//                    return;
//                }
//                node = node.next.get(ch);
//            }
//            node.end -= count;
//        }
//
//
//    }
//
//    /**
//     * Your Trie object will be instantiated and called as such:
//     * Trie obj = new Trie();
//     * obj.insert(word);
//     * boolean param_2 = obj.search(word);
//     * boolean param_3 = obj.startsWith(prefix);
//     */
//
//
//    public static void main(String[] args) {
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.insert("apple");
//        trie.insert("appd");
//        trie.insert("applc");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.getWordCount("apple"));
//        trie.delete("apple", trie.getWordCount("apple"));
//        System.out.println();
//    }
//}
