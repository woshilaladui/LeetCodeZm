package com.whut.study.io.ioStream;

import org.apdplat.word.vector.F;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2022/3/20 20:59
 * @desription
 */
public class Test1 {
    public static void main(String[] args) {
        //C:\Users\Administrator\Desktop\张娟图库
        String url = "C:\\Users\\Administrator\\Desktop\\张娟图库\\test.txt";
        try {

            OutputStream outputStream = null;
            OutputStreamWriter outputStreamWriter = null;
            outputStream = new FileOutputStream(url);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "生料均化库_441_4");
            map.put(2, "喂量系统_442_2");
            map.put(3, "预热器_443_5");
            map.put(4, "回转窑_444_7");
            map.put(5, "篦冷机_445_4");
            map.put(6, "硅酸盐水泥_446_3");
            map.put(7, "游离氧化钙_447_2");
            map.put(8, "生料分配器_448_1");
            map.put(9, "螺旋输送机_449_2");
            map.put(10, "回转定容鼓风机_450_1");
            map.put(11, "四级筒_451_2");
            map.put(12, "排风机_452_3");
            map.put(13, "入窑生料_453_5");
            map.put(14, "喂煤量_454_4");
            map.put(15, "新型干法水泥_455_3");
            map.put(16, "水泥熟料_2756_10");
            map.put(17, "熟料冷却_2757_2");
            map.put(18, "窑外分解_2758_1");
            map.put(19, "石灰石原料_2759_4");
            map.put(20, "熟料煅烧_2760_5");
            map.put(21, "生料制备_2761_4");
            map.put(22, "水泥粉磨_2762_2");
            map.put(23, "分解炉_2763_6");
            map.put(24, "三次风阀_2764_2");
            map.put(25, "四级出口_2765_3");
            map.put(26, "四级下料_2766_3");
            map.put(27, "窑尾温度_2767_4");
            map.put(28, "预风筒_2768_2");
            map.put(29, "二次风温_2769_2");
            map.put(30, "窑电流_2770_2");
            //2797
            int mapIndex = 1;
            for (int i = 0; i < 4312; i++) {
                String str = map.get(mapIndex);
                System.out.println(str);
                String[] strs = str.split("_");
                int index = Integer.parseInt(strs[1]);
                if (i == index) {
                    System.out.println("asd" + map.get(mapIndex));
                    outputStreamWriter.write(strs[0] + "--------" + strs[2] + "\n");
                    if (mapIndex < 30)
                        mapIndex++;
                } else {
                    outputStreamWriter.write("\n");
                }
                outputStreamWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
