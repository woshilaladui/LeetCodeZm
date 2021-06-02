package com.whut.study.proxy;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/22 10:46
 * @desription
 */
public class Test implements CallbackHandler {
    public static void main(String[] args) throws ParseException {

        Integer a = 128;
        Integer b = 128;

        System.out.println(a == b);



//        String startStr = "2021-04-20 10:00:00";
//        String endStr = "2021-04-20 10:00:49";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date start = sdf.parse(startStr);
//        Date end = sdf.parse(endStr);
//
//        System.out.println((start.getTime() - end.getTime()) / (1000));
//
//
//        Map<Integer, Integer[]> map = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        map.put(10, new Integer[]{1, 3});
//        map.put(8, new Integer[]{-2, 2});
//
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//
//            Integer[] array;
//
//            array = (Integer[]) entry.getValue();
//
//            System.out.println(array[0] + " " + array[1]);
//        }


//        Set<String> set = new HashSet<>();
//
//        set.add("apple");
//     //   javax.security.auth.callback.Callback


    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

    }


}
