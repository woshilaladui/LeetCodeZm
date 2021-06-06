package com.whut.study.io.ioStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/5 15:08
 * @desription
 */
public class Test {


    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\学习\\java\\xmind//test.txt");

        InputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\学习\\java\\xmind//test.txt"));

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\学习\\java\\xmind//test3.txt");


        int len = 0;

        StringBuffer str = new StringBuffer();

        String line;

        byte[] b = new byte[inputStream.available()];
        //一次读取一个字节
        while ((len = inputStream.read(b)) != -1) {
            fileOutputStream.write(b);
        }

        System.out.println(str.toString());
        inputStream.close();
    }
}
