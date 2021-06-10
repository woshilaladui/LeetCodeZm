package com.whut.study.io.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class A5 {

    public static void main(String[] args) {

        //C:\Users\Administrator\Desktop\郑萌\1105实验室\项目\水泥调研\数据\附件1：“节能减排”典型案例分析报告集\第四篇：水泥粉磨类
        String filePath = "C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\项目\\水泥调研\\数据\\附件1：“节能减排”典型案例分析报告集\\第四篇：水泥粉磨类\\D-SNM-G-011天津水泥院水泥立磨终粉磨技术情况调查.txt" ;
        //String filePath = "C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\学习\\java\\xmind//test.txt" ;
        String filePath2 = "C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\学习\\java\\xmind//test3.txt" ;
        File file = new File( filePath ) ;
        File file2 = new File( filePath2 ) ;
        copyFile( file , file2 );



    }

    private static void copyFile( File oldFile , File newFile ){
        InputStream inputStream = null ;
        InputStreamReader inputStreamReader = null ;

        OutputStream outputStream = null ;
        OutputStreamWriter outputStreamWriter = null ;
        StringBuilder sb = new StringBuilder();

        try {
            inputStream = new FileInputStream( oldFile ) ; //创建输入流
            inputStreamReader = new InputStreamReader( inputStream, StandardCharsets.UTF_8) ; //创建转换输入流

            outputStream = new FileOutputStream( newFile ) ; //创建输出流
            outputStreamWriter = new OutputStreamWriter( outputStream ) ; //创建转换输出流

            int result = 0 ;

            char []c = new char[1];

            while( (result = inputStreamReader.read(c)) != -1){
                //System.out.println(c);
                sb.append(c);
                outputStreamWriter.write( new String(c,0,result) );
            }

            String str = sb.toString();

            String replace = str.replaceAll("\\r\\n", ",");
            //System.out.println(str);
            System.out.println(replace.replaceAll(" ",""));

            //System.out.println(replace);

            outputStreamWriter.flush();  //强制把缓冲写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{

            if ( outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( inputStreamReader != null ) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

