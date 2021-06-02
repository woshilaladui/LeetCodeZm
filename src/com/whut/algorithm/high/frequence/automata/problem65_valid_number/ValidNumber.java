package com.whut.algorithm.high.frequence.automata.problem65_valid_number;

import org.omg.PortableServer.POA;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/15 19:31
 * @desription
 */
public class ValidNumber {


    public static boolean isNumber(String s) {

        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        //初始状态
        Map<CharType, State> startMap = new HashMap<>();
        startMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        startMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        startMap.put(CharType.CHAR_POINT, State.STATE_POINT_WHITOUT_INT);
        transfer.put(State.STATE_START, startMap);

        //符号状态
        Map<CharType, State> signMap = new HashMap<>();
        signMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        signMap.put(CharType.CHAR_POINT, State.STATE_POINT_WHITOUT_INT);
        transfer.put(State.STATE_INT_SIGN, signMap);

        //整数部分
        Map<CharType, State> intMap = new HashMap<>();
        intMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        intMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_INTEGER, intMap);

        //小数点左边有数字部分
        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_POINT, pointMap);

        //小数点左边无数字
        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WHITOUT_INT, pointWithoutIntMap);

        //小数部分
        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_FRACTION, fractionMap);

        //字符E部分
        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        transfer.put(State.STATE_EXP, expMap);

        //指数符号部分
        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        //指数部分
        Map<CharType, State> expNumberMap = new HashMap<>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        int n = s.length();

        //初始状态为开始状态
        State state = State.STATE_START;

        char[] c_s = s.toCharArray();

        for (int i = 0; i < n; i++) {
            CharType charType = toCharType(c_s[i]);
            if (!transfer.get(state).containsKey(charType)) {
                return false;
            } else {
                //获取下一个状态
                state = transfer.get(state).get(charType);
            }
        }

        return state == State.STATE_INTEGER ||
                state == State.STATE_POINT ||
                state == State.STATE_FRACTION ||
                state == State.STATE_EXP_NUMBER;

    }


    public static CharType toCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (c == 'e' || c == 'E')
            return CharType.CHAR_EXP;
        else if (c == '.')
            return CharType.CHAR_POINT;
        else if (c == '+' || c == '-')
            return CharType.CHAR_SIGN;
        else
            return CharType.CHAR_ILLEGAL;
    }

    /**
     * 状态机转化符
     */
    enum CharType {
        CHAR_NUMBER,
        CHAR_POINT,
        CHAR_EXP,
        CHAR_SIGN,
        CHAR_ILLEGAL
    }

    enum State {
        STATE_START,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WHITOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(isNumber(""));

        Long time1 = System.currentTimeMillis() ;

        //TimeUnit.SECONDS.sleep(10);

        Long time2 = System.currentTimeMillis()  + 1000*60;

        Date date2 = new Date(time2);
        Date date1 = new Date(time1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(time1);
        System.out.println(time2);
        System.out.println((time2 - time1));

        System.out.println("----------------------------");
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        threadPoolExecutor.submit(() -> {
            for(int i =0 ;i<10;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();



        threadPoolExecutor.shutdown();
    }
}
