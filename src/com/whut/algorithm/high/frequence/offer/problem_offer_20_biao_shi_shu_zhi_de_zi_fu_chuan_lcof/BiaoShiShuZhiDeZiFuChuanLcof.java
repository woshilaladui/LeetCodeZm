package com.whut.algorithm.high.frequence.offer.problem_offer_20_biao_shi_shu_zhi_de_zi_fu_chuan_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/5 15:05
 * @desription
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {

    public static boolean isNumber(String s) {

        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        //初始状态/
        Map<CharType, State> startMap = new HashMap<>();
        startMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        startMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        startMap.put(CharType.CHAR_POINT, State.STATE_POINT_WHITOUT_INT);
        startMap.put(CharType.CHAR_BLANK,State.STATE_START);
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
        intMap.put(CharType.CHAR_BLANK,State.STATE_TAIL_BLANK);
        transfer.put(State.STATE_INTEGER, intMap);

        //小数点左边有数字部分
        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        pointMap.put(CharType.CHAR_BLANK,State.STATE_TAIL_BLANK);
        transfer.put(State.STATE_POINT, pointMap);

        //小数点左边无数字
        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WHITOUT_INT, pointWithoutIntMap);

        //小数部分
        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_BLANK,State.STATE_TAIL_BLANK);
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
        expNumberMap.put(CharType.CHAR_BLANK,State.STATE_TAIL_BLANK);
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        Map<CharType,State> tailBlankMap = new HashMap<>();
        tailBlankMap.put(CharType.CHAR_BLANK,State.STATE_TAIL_BLANK);
        transfer.put(State.STATE_TAIL_BLANK,tailBlankMap);


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
                state == State.STATE_EXP_NUMBER||
                state == State.STATE_TAIL_BLANK;

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
        else if(c == ' ')
            return CharType.CHAR_BLANK;
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
        CHAR_BLANK,
        CHAR_ILLEGAL
    }

    enum State {
        STATE_START,
        //符号位
        STATE_INT_SIGN,
        //整数部分
        STATE_INTEGER,
        //小数点左边有整数
        STATE_POINT,
        //小数点左边无整数部分
        STATE_POINT_WHITOUT_INT,
        //小数部分
        STATE_FRACTION,
        //字符e
        STATE_EXP,
        //指数符号位
        STATE_EXP_SIGN,
        //指数部分
        STATE_EXP_NUMBER,
        //末尾空格
        STATE_TAIL_BLANK,
        STATE_END
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
    }
}
