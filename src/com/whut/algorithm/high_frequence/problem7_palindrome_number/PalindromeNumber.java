package com.whut.algorithm.high_frequence.problem7_palindrome_number;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/20 12:50
 * @desription
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        String s = x + "";

        int left = 0, right = s.length() - 1;

        while (left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }



        return true;
    }

    public static void main(String[] args) {

        String S = "Ｋａｍｂｈａｔｌａ Ｎ． Ｃｏｍｂｉｎｉｎｇ ｌｅｘｉｃａｌ，ｓｙｎｔａｃｔｉｃ，ａｎｄ ｓｅｍａｎｔｉｃ ｆｅａｔｕｒｅｓ ｗｉｔｈ\n" +
                "ｍａｘｉｍｕｍ ｅｎｔｒｏｐｙ ｍｏｄｅｌｓ ｆｏｒ ｅｘｔｒａｃｔｉｎｇ ｒｅｌａｔｉｏｎｓ［Ｃ］ ／ ／ Ｐｒｏｃ ｏｆ Ｍｅｅｔｉｎｇ\n" +
                "ｏｆ ｔｈｅ Ａｓｓｏｃｉａｔｉｏｎ ｆｏｒ Ｃｏｍｐｕｔａｔｉｏｎａｌ Ｌｉｎｇｕｉｓｔｉｃｓ． ２００４．";
        System.out.println('Ｋ'-'0');
        System.out.println('K'-'0');

        char []array = S.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : array) {
            if(c == 'Ｋ')
                System.out.println("aaaaaa");
            sb.append(c);
        }

        System.out.println(sb.toString());
        System.out.println(isPalindrome(1211));
    }
}
