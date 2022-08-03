package com.whut.interview.tuhoughworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/12 13:00
 * @desription
 */
public class Main2 {

    public static List<String> findComplement(List<String> PhoneAFeatures, List<String> PhoneBFeatures) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < PhoneBFeatures.size(); i++) {
            String str = PhoneBFeatures.get(i);
            if (!PhoneAFeatures.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> PhoneAFeatures = Arrays.asList("c","d","f");
        List<String> PhoneBFeatures = Arrays.asList("c","d","f");
        List<String> result = findComplement(PhoneAFeatures,PhoneBFeatures);
        for (String s : result) {
            System.out.print(s+" ");
        }
    }
}
