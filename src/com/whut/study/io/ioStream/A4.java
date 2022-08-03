package com.whut.study.io.ioStream;

import java.io.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/5 15:59
 * @desription
 */
public class A4 {
    public static void main(String[] args) {

        String filePath = "E:\\code\\shuini_knowledege//merge_sgns_bigram_char300.txt";
        String filePath2 = "E:\\code\\shuini_knowledege//merge_sgns_bigram_char300_new.txt";

        File file = new File(filePath);
        File file2 = new File(filePath2);
        copyFile(file, file2);
    }

    private static void copyFile(File oldFile, File newFile) {
        Reader reader = null;
        BufferedReader bufferedReader = null;

        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        int i = 0;
        try {
            reader = new FileReader(oldFile);
            bufferedReader = new BufferedReader(reader);

            writer = new FileWriter(newFile);
            bufferedWriter = new BufferedWriter(writer);

            String result = null; //每次读取一行的内容

            while ((result = bufferedReader.readLine()) != null) {
                if(i++ == 0){
                    continue;
                }

                bufferedWriter.write(result+"\n");  //把内容写入文件
                //换行，result 是一行数据，所以每写一行就要换行
                //bufferedWriter.newLine();
            }

            bufferedWriter.flush();  //强制把数组内容写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();  //关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bufferedReader.close();  //关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //1348469
        System.out.println(i);
    }


}
