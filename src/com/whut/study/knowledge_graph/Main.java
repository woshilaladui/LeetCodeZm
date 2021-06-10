package com.whut.study.knowledge_graph;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.dictionary.DictionaryFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/8 14:49
 * @desription
 */
public class Main {

    private void addDict(){
        // 批量操作
        List<String> words = new ArrayList<>();
        words.add("基本信息");
        words.add("生产基本数据");
        words.add("调研状况");
        words.add("李京涛");
        words.add("李福洲");
// 添加一批自定义词
        DictionaryFactory.getDictionary().clear();
        DictionaryFactory.getDictionary().addAll(words);
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.addDict();

        /**
         * // 批量操作
         * List<String> words = new ArrayList<>();
         * words.add("刘德华");
         * words.add("景甜");
         * words.add("赵丽颖");
         * // 添加一批自定义词
         * DictionaryFactory.getDictionary().addAll(words);
         */

        /**
         * String input = "d:/text.txt";
         * String output = "d:/word.txt";
         * 移除停用词：WordSegmenter.seg(new File(input), new File(output));
         * 保留停用词：WordSegmenter.segWithStopWords(new File(input), new File(output));
         */
        String input = "C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\项目\\毕业项目\\input.txt";
        String output = "C:\\Users\\Administrator\\Desktop\\郑萌\\1105实验室\\项目\\毕业项目\\output.txt";



        try {
            WordSegmenter.seg(new File(input), new File(output));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
