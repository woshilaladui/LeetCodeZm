package com.whut.daily5.problem12;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/18 15:52
 * @desription
 */
public class Problem12 {

    public static void main(String[] args) {

        System.out.println(intToRoman(27));
        System.out.println(intToRoman(24));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

//        Map<Integer,Character> map = new HashMap<>();
//        map.put(1,'I');
//        map.put(5,'V');
//        map.put(10,'X');
//        map.put(50,'L');
//        map.put(100,'C');
//        map.put(500,'D');
//        map.put(1000,'M');

//        char []values = new char[]{'I','V','X','L','C','D','M'};
//        int []keys = new int[]{1,5,10,50,100,500,1000};
        String []values = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int []keys = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int index = 12;

        String result = "";

        int tempNum = num;

        while (tempNum > 0){

            while (keys[index] > tempNum)
                index--;


            if(tempNum == 4){
                result = result + "IV";
                tempNum-=4;
                continue;
            }

            else if(tempNum == 9){
                result = result + "IX";
                tempNum-=9;
                continue;
            }
            else if(tempNum == 40){
                result = result + "XL";
                tempNum-=40;
                continue;
            }
            else if(tempNum == 90){
                result = result + "XC";
                tempNum-=90;
                continue;
            }

            else if(tempNum == 400){
                result = result + "CD";
                tempNum-=400;
                continue;
            }
            else if(tempNum == 900){
                result = result + "CM";
                tempNum-=900;
                continue;
            }

            else {
                result = result + values[index];
            }

            tempNum -= keys[index];

        }




        return result;


    }

}
