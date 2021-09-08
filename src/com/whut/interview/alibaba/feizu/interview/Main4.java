package com.whut.interview.alibaba.feizu.interview;

import org.apache.tools.ant.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/29 11:46
 * @desription
 */
public class Main4 {
    public static void main(String[] args) {
        List<String> list = null;

        sort(list);
        //DATE_FORMAT(hys.date,'%Y-%m-%d')
    }

    public static void sort(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
//            if (StringUtils.isBlank(o1) || StringUtils.isBlank(o2)){
//                return 0;
//            }
            return o1.compareTo(o2);
        });
    }

    /**
     *
     *
     *
     *
     */
}
