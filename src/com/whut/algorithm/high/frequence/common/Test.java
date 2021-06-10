package com.whut.algorithm.high.frequence.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/6 15:15
 * @desription
 */
public class Test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date1 = sdf.parse("2021-03-12 11:12:12");
        Date date2 = sdf.parse("2021-03-12 11:14:14");

        int l = (int) ((date2.getTime()-date1.getTime()))/(1000 *60);

        System.out.println(l);

        User user = new User(1);
        System.out.println(user.hashCode());



    }
}
