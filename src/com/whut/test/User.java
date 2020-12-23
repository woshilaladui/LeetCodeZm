package com.whut.test;

import java.io.*;
import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/12 17:13
 * @desription
 */

public class User {


    public static void main(String[] args) {

        File file = new File("D:\\data\\input\\order.txt");

        File fileOut = new File("D:\\data\\input\\out.txt");

        try {

//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
//
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOut));

//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut)));

            Reader reader = new InputStreamReader(new FileInputStream(file));
            Writer writer = new OutputStreamWriter(new FileOutputStream(fileOut));

            byte[] buffer = new byte[1024];

            String temp;

            int len;

            char[] chars = new char[2];

            while ((len = reader.read(chars)) != -1) {

                writer.write(chars,0,len);
                writer.flush();


            }

            reader.close();
            writer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
