package com.whut.study.resolve;

import java.io.*;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/9 10:05
 * @desription
 */
public class JsonResolve {


    private String str;


    /**
     * @param jsonstring
     * @return
     */
    @SuppressWarnings("unchecked")
    public Object json2Map(String jsonstring) {
        char[] cs = jsonstring.toCharArray();
        Stack<Map> maps = new Stack<>(); //用来表示多层的json对象
        Stack<List> lists = new Stack<>(); //用来表示多层的list对象
        Stack<Boolean> islist = new Stack<>();//判断是不是list
        Stack<String> keys = new Stack<>(); //用来表示多层的key

        String keytmp = null;
        Object valuetmp = null;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < cs.length; i++) {

            switch (cs[i]) {
                case '{': //如果是{map进栈
                    maps.push(new HashMap());
                    islist.push(false);
                    break;
                case ':'://如果是：表示这是一个属性建，key进栈
                    keys.push(builder.toString());
                    builder = new StringBuilder();
                    break;
                case '[':
                    lists.push(new ArrayList());
                    islist.push(true);
                    break;
                case ',':
                    if (builder.length() > 0)
                        valuetmp = builder.toString();
                    builder = new StringBuilder();

                    boolean listis = islist.peek();
                    if (!listis) {
                        keytmp = keys.pop();
                        maps.peek().put(keytmp, valuetmp);
                    } else
                        lists.peek().add(valuetmp);

                    break;
                case ']':
                    islist.pop();

                    if (builder.length() > 0)
                        valuetmp = builder.toString();
                    lists.peek().add(valuetmp);
                    valuetmp = lists.pop();
                    builder = new StringBuilder();
                    break;
                case '}':
                    islist.pop();
                    //这里做的和，做的差不多，只是需要把valuetmp=maps.pop();把map弹出栈
                    keytmp = keys.pop();

                    if (builder.length() > 0)
                        valuetmp = builder.toString();

                    builder = new StringBuilder();
                    maps.peek().put(keytmp, valuetmp);
                    valuetmp = maps.pop();
                    break;
                default:
                    builder.append(cs[i]);
                    break;
            }

        }
        return valuetmp;
    }


    public static void main(String[] args) throws IOException {
        JsonResolve jsonResolve = new JsonResolve();

        StringBuilder sb = new StringBuilder();

        InputStream in = new FileInputStream(new File("E:\\code\\github_code\\interview_written\\src\\com\\whut\\study\\resolve\\json.txt"));

        byte[] buffer = new byte[1024];

        int length = 0 ;

        while ( (length = in.read( buffer ) )!= -1 ) {
            sb.append(new String(buffer));
        }

        jsonResolve.str = sb.toString();

        Object o = jsonResolve.json2Map(jsonResolve.str);

        System.out.println();


    }
}
