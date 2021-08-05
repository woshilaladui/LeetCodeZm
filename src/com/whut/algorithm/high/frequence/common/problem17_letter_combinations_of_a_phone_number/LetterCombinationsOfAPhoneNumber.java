package com.whut.algorithm.high.frequence.common.problem17_letter_combinations_of_a_phone_number;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/1 20:31
 * @desription
 */
public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {

        List<String> result = new LinkedList<>();

        StringBuilder path = new StringBuilder();

        Map<Character, String> map = new HashMap<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(
                result,
                path,
                digits,
                0,
                map
        );
//
//        for (String s : result) {
//            System.out.println(s);
//        }

        return result;
    }

    private static void backTrack(
            List<String> result,
            StringBuilder path,
            String digits,
            int index,
            Map<Character, String> map
    ) {
        if (index == digits.length()) {
            result.add(new String(path));
            return;
        }

        char digit = digits.charAt(index);

        String letter = map.get(digit);

        for (int i = 0; i < letter.length(); i++) {

            path.append(letter.charAt(i));
            //注意不是 i+1 是index + 1 去下一个数字
            backTrack(result, path, digits, index + 1, map);
            //移除刚添加进去的
            //path.deleteCharAt(index);
            path.deleteCharAt(path.toString().length() - 1);

        }

    }

    public static void main(String[] args) {

        //letterCombinations("");
        String s = "Zhang X, Shen J, Wang Y, et al. An environmental sustainability assessment of China’s cement industry based on emergy[J]. Ecological indicators, 2017, 72: 452-458.\n" +
                "Pannakkong W, Pham V H, Huynh V N. A Novel Hybridization of ARIMA, ANN, and K-Means for Time Series Forecasting[J]. International Journal of Knowledge and Systems Science (IJKSS), 2017, 8(4): 30-53.\n" +
                "Ratnaparkhi A . Maximum Entropy Model for Part-Of-Speech Tagging[C]. Proc. Empirical Method for Natural Language Processings, 1996.\n" +
                "Fang C H, Chen Y L, Yeh M Y, et al. Multi-head Attention with Hint Mechanisms for Joint Extraction of Entity and Relation[C]//Database Systems for Advanced Applications. DASFAA 2021 International Workshops: BDQM, GDMA, MLDLDSA, MobiSocial, and MUST, Taipei, Taiwan, April 11–14, 2021, Proceedings 26. Springer International Publishing, 2021: 321-335.\n" +
                "Gong L, Zhang X, Chen T, et al. Recognition of Disease Genetic Information from Unstructured Text Data Based on BiLSTM-CRF for Molecular Mechanisms[J]. Security and Communication Networks, 2021, 2021.\n" +
                "Park Y, Chang S Y, Krishnamurthy L M. Watermarking for detecting freeloader misbehavior in software-defined networks[C]//2016 International conference on computing, networking and communications (ICNC). IEEE, 2016: 1-6.\n" +
                "喻雪寒, 何琳, 徐健. 基于 RoBERTa-CRF 的古文历史事件抽取方法研究[J]. 数据分析与知识发现, 2021: 1.\n" +
                "Aone C , Halverson L , Hampton T , et al. Sra: Description Of The Ie2 System Used for MUC-7. 1998. \n" +
                "RauLF. Extracting Company Names from Text[C]. In:Proceeding softhe 7th IEEE Conference on Artificial Intelligence Applications.1991:29-32[8]Nickel M，Murphy K，Tresp V，et al. A Review of Relational Machine Learning for Knowledge Graphs[J]. Proceedings of the IEEE，2016，104（1）:11-33.\n" +
                "Jain P, Goel T, Verma I, et al. Extracting Tabular data for Question-Answering from Documents[M]//8th ACM IKDD CODS and 26th COMAD. 2021: 400-404.\n" +
                "Chiu J P C, Nichols E. Named entity recognition with bidirectional LSTM-CNNs[J]. Transactions of the Association for Computational Linguistics, 2016, 4: 357-370.\n" +
                "Ma X, Hovy E. End-to-end sequence labeling via bi-directional lstm-cnns-crf[J]. arXiv preprint arXiv:1603.01354, 2016.\n" +
                "Liu L, Shang J, Ren X, et al. Empower sequence labeling with task-aware neural language model[C]//Proceedings of the AAAI Conference on Artificial Intelligence. 2018, 32(1).\n" +
                "Liu T , Yao J G , Lin C Y . Towards Improving Neural Named Entity Recognition with Gazetteers[C]// Proceedings of the 57th Annual Meeting of the Association for Computational Linguistics. 2019.\n" +
                "隋臣.基于深度学习的中文命名实体识别研究[D].浙江大学硕士学位论文,2017\n" +
                "Greenberg N , Bansal T , Verga P , et al. Marginal Likelihood Training of BiLSTM-CRF for Biomedical Named Entity Recognition from Disjoint Label Sets[C]// Proceedings of the 2018 Conference on Empirical Methods in Natural Language Processing. 2018.\n" +
                "Wu Y , Min J , Lei J , et al. Named Entity Recognition in Chinese Clinical Text Using Deep Neural Network[J]. Studies in health technology and informatics, 2015, 216:624-628.\n" +
                "陈曙东,欧阳小叶.命名实体识别技术综述[J].无线电通信技术,2020,46(03):251-260.\n" +
                "万静, 李浩铭, 严欢春,等. 基于循环卷积神经网络的实体关系抽取方法研究[J]. 计算机应用研究, 2020, v.37;No.341(03):65-69.\n" +
                "周晓磊,赵薛蛟,刘堂亮,宗子潇,王其乐,里剑桥.基于SVM-BILSTM-CRF模型的财产纠纷命名实体识别方法[J].计算机系统应用,2019.28(1):245-250.\n" +
                "Fu X, Zhang G. A More Efficient Chinese Named Entity Recognition base on BERT and Syntactic Analysis[J]. arXiv preprint arXiv:2101.11423, 2021.\n" +
                "Yang H, Hsu W. Named Entity Recognition from Synthesis Procedural Text in Materials Science Domain with Attention-Based Approach[J]. 2021.\n" +
                "王毅，谢娟，成颖. 结合 LSTM 和 CNN 混合架构的深度神经网络语言模型[J]. 情报学报，2018，37（2）: 194-205.[23] Zhang L，Moldovan D. Chinese Relation Classification via Convolutional Neural Networks[C]//The Thirty-First International Flairs Conference. 2018.\n" +
                "Upadhyay R , Fujii A . Semantic knowledge extraction from research documents[C]// Computer Science & Information Systems. IEEE, 2016.\n" +
                "Yue Q, Li X, Li D. Chinese Relation Extraction on Forestry Knowledge Graph Construction[J]. COMPUTER SYSTEMS SCIENCE AND ENGINEERING, 2021, 37(3): 423-442.\n" +
                "Dong C , Zhang J , Zong C , et al. Character-Based LSTM-CRF with Radical-Level Features for Chinese Named Entity Recognition[C]// International Conference on Computer Processing of Oriental Languages National CCF Conference on Natural Language Processing and Chinese Computing. Springer International Publishing, 2016.\n" +
                "Han X, Zhou F, Hao Z, et al. MAF-CNER: A Chinese Named Entity Recognition Model Based on Multifeature Adaptive Fusion[J]. Complexity, 2021, 2021.\n" +
                "佘恒.基于深度学习的中文文本实体关系抽取研究与实现[D].北京：北京邮电大学，2019.\n" +
                "Liu J, Gao L, Guo S, et al. A hybrid deep-learning approach for complex biochemical named entity recognition[J]. Knowledge-Based Systems, 2021: 106958.\n" +
                "Hou R, Li H, Feng H, et al. An entity relation extraction algorithm based on BERT (wwm-ext)-BiGRU-Attention[C]//Proceedings of the 2020 International Conference on Cyberspace Innovation of Advanced Technologies. 2020: 130-135.\n" +
                "Shi Y, Qin Q. Construction of Neurosurgery Knowledge Graph Based on Bi-LSTM-CRF Model[C]//Proceedings of the 4th International Conference on Computer Science and Application Engineering. 2020: 1-5.\n" +
                "Shetty M, Bansal C. Mining Knowledge Graphs From Incident Reports[J]. arXiv preprint arXiv:2101.05961, 2021.\n" +
                "Shi Y, Qin Q. Construction of Neurosurgery Knowledge Graph Based on Bi-LSTM-CRF Model[C]//Proceedings of the 4th International Conference on Computer Science and Application Engineering. 2020: 1-5.\n" +
                "Y Zhang, Qi P , Manning C D . Graph Convolution over Pruned Dependency Trees Improves Relation Extraction[C]// Proceedings of the 2018 Conference on Empirical Methods in Natural Language Processing. 2018.\n" +
                "Zhang Y , Guo Z , Lu W . Attention Guided Graph Convolutional Networks for Relation Extraction[C]// Proceedings of the 57th Annual Meeting of the Association for Computational Linguistics. 2019.\n" +
                "Topal M O, Bas A, van Heerden I. Exploring transformers in natural language generation: GPT, BERT, and XLNET[J]. arXiv preprint arXiv:2102.08036, 2021.\n" +
                "刘辉,江千军,桂前进,张祺,王梓豫,王磊,王京景.实体关系抽取技术研究进展综述[J].计算机应用研究,2020,37(S2):1-5. \n" +
                "Liu W , Yu B , Zhang C , et al. Chinese Named Entity Recognition Based on Rules and Conditional Random Field[C]// the 2018 2nd International Conference. 2018.\n" +
                "Zeng X，He S，Liu K，et al. Large scaled relation extraction with reinforcement learning[C]//Thirty-Second AAAI Conference on Artificial Intelligence. 2018.\n" +
                "Mai K，Pham T H，Nguyen M T，et al. An empirical study on fine-grained named entity recognition[C]//Proceedings of the 27th International Conference on Computational Linguistics. 2018: 711-722.\n" +
                "Xu B，Xu Y，Liang J，et al. CN-DBpedia: A never-ending Chinese knowledge extraction system[C]//International Conference on Industrial，Engineering and Other Applications of Applied Intelligent Systems. Springer，Cham，2017: 428-438.\n" +
                "Dong C, Zhang J, Zong C, et al. Character-based LSTM-CRF with radical-level features for Chinese named entity recognition[M]//Natural Language Understanding and Intelligent Applications. Springer, Cham, 2016: 239-250.\n" +
                "Huang Y，Yang X，Zhuang F，et al. Automatic Chinese Reading Comprehension Grading by LSTM with Knowledge Adaptation[C]//Pacific-Asia Conference on Knowledge Discovery and Data Mining. Springer，Cham，2018: 118-129.\n" +
                "Li S L，Xu B，Chung T L. Definition Extraction with LSTM Recurrent Neural Networks[M]//Chinese Computational Linguistics and Natural Language Processing Based on Naturally Annotated Big Data. Springer，Cham，2016: 177-189.\n" +
                "Sha L，Li S，Chang B，et al. Recognizing Textual Entailment via Multi-task Knowledge Assisted LSTM[M]//Chinese Computational Linguistics and Natural Language Processing Based on Naturally Annotated Big Data. Springer，Cham，2016: 285-298.\n" +
                "Li S L，Xu B，Chung T L. Definition Extraction with LSTM Recurrent Neural Networks[M]//Chinese Computational Linguistics and Natural Language Processing Based on Naturally Annotated Big Data. Springer，Cham，2016: 177-189.\n" +
                "Liu J，Ren H，Wu M，et al. Multiple relations extraction among multiple entities in unstructured text[J]. Soft Computing，2018，22（13）: 4295-4305.\n" +
                "沈晓冬. 水泥低热耗制备与高效应用[M]. 中国建材工业出版社，2016.\n" +
                "Song Y，Rao R N，Shi J. Relation Classification in Knowledge Graph Based on Natural Language Text[C]//2018 IEEE 9th International Conference on Software Engineering and Service Science （ICSESS）. IEEE，2018: 1104-1107.\n" +
                "Shi Peng，Lin Jimmy, Simple BERT models for realtion extraction and semantic role labeling [J]. arXiv prepring，arXiv:1904.05255,2019.";


        String[] sArray = s.split("\n");

        List<String> result = Arrays.asList(sArray);

        Collections.shuffle(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
            //System.out.println();
        }


    }
}
