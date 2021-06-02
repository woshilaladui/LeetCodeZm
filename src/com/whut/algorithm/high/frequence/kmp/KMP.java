package com.whut.algorithm.high.frequence.kmp;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/15 14:55
 * @desription
 */
public class KMP {

    private static int search(String haystack, String needle) {

        int lenS = haystack.length();
        int lenT = needle.length();

        char[] c_s = haystack.toCharArray();
        char[] c_t = needle.toCharArray();

        int c = 0, d = 0;

        while (c < lenS && d < lenT) {
            if (c_s[c] == c_t[d]) {
                c++;
                d++;
            } else {
                c = c - d + 1;
                d = 0;
            }
        }

        return d == lenT ? c - d : -1;
    }

    private static int kmp(String haystack, String needle) {

        if (haystack.length() == 0 && needle.length() == 0)
            return 0;

        if (needle.length() == 0)
            return 0;


        int[] next = new int[needle.length()];

        getNext(needle.toCharArray(), next);

        int lenS = haystack.length();
        int lenT = needle.length();

        char[] c_s = haystack.toCharArray();
        char[] c_t = needle.toCharArray();

        int c = 0, d = 0;
        while (c < lenS && d < lenT) {
            if (d == -1 || c_s[c] == c_t[d]) {
                c++;
                d++;
            } else {
                d = next[d];
            }
        }

        return d == lenT ? c - d : -1;
    }

    private static void getNext(char[] T, int[] next) {
        //长串
        int c = 0;
        //短串
        int d = -1;
        int len = T.length;

        //万能匹配符
        next[0] = -1;

        while (c < len - 1) {
            if (d == -1 || T[c] == T[d]) {
                c++;
                d++;
                //next[c+1] = next[c] +1 = d+1
                //next[c] = d;
                next[c] = next[c-1] +1;
            } else {
                d = next[d];
            }
        }

    }

    public static void main(String[] args) {
        String S = "aagdgfdababsdsd";
        String T = "abab";
        int[] next = new int[T.length()];
        getNext(T.toCharArray(), next);
        for (int i : next) {
            System.out.print(i);
        }
        System.out.println();

        System.out.println(kmp(S, T));
    }
}
