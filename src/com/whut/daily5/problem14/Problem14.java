package com.whut.daily5.problem14;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/18 17:15
 * @desription
 */
public class Problem14 {

    public static void main(String[] args) {

//        String s = "abcd";
//
//        System.out.println(s.substring(1,3));


      //String []strs = new String[]{"flower","flow","flight"};
  //      String []strs = new String[]{"dog","racecar","car"};

        String []strs = new String[]{"aa","a"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {



        if(strs.length == 0)
            return "";

        String temps = strs[0];
        String subtemps = "";

        boolean flag = true;

        for(int i=0;i<temps.length();i++){
            subtemps = subtemps + temps.charAt(i);

            for(int j=0;j<strs.length;j++){

                if(subtemps.length()>strs[j].length() ||!strs[j].substring(0,subtemps.length()).equals(subtemps)){
                    flag = false;
                    break;
                }

//                if(!strs[j].contains(subtemps)){
//
//                }
            }

            if(!flag){
               // System.out.println("--> = " + subtemps);
                subtemps = subtemps.substring(0,subtemps.length()-1);
                break;
            }

        }


        return subtemps;

    }

}
