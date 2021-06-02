//package com.whut.common.nlp;
//
//import com.hankcs.hanlp.HanLP;
//import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
//import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
//import com.hankcs.hanlp.restful.HanLPClient;
//import com.hankcs.hanlp.seg.common.Term;
//import com.hankcs.hanlp.tokenizer.StandardTokenizer;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/5/7 10:52
// * @desription
// */
//public class NLPTest {
//
//    public static void main(String[] args) throws IOException
//    {
//        WordVectorModel wordVectorModel = trainOrLoadModel();
//        printNearest("中国", wordVectorModel);
//        printNearest("美丽", wordVectorModel);
//        printNearest("购买", wordVectorModel);
//
//        // 文档向量
//        DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);
//        String[] documents = new String[]{
//                "山东苹果丰收",
//                "农民在江苏种水稻",
//                "奥运会女排夺冠",
//                "世界锦标赛胜出",
//                "中国足球失败",
//        };
//
//        System.out.println(docVectorModel.similarity(documents[0], documents[1]));
//        System.out.println(docVectorModel.similarity(documents[0], documents[4]));
//
//        for (int i = 0; i < documents.length; i++)
//        {
//            docVectorModel.addDocument(i, documents[i]);
//        }
//
//        printNearestDocument("体育", documents, docVectorModel);
//        printNearestDocument("农业", documents, docVectorModel);
//        printNearestDocument("我要看比赛", documents, docVectorModel);
//        printNearestDocument("要不做饭吧", documents, docVectorModel);
//    }
//}
