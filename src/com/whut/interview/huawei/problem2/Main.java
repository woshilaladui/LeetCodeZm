package com.whut.interview.huawei.problem2;

import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/1 20:46
 * @desription
 */
public class Main {

    static HashMap<String, List<String>> classMap = new HashMap<>();
    static HashMap<String, SortedSet<String>> instanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String enter = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");

            if (s1[1].equals("subClassOf")) {
                if (classMap.get(s1[2]) == null) {
                    classMap.put(s1[2], Arrays.asList(s1[0]));
                }
                classMap.put(s1[0], new ArrayList<>());
            } else {
                SortedSet<String> set = instanceMap.get(s1[2]);

                if (set == null) {
                    set = new TreeSet<>(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    });
                }

                set.add(s1[0]);
                instanceMap.put(s1[2], set);
            }
        }//end for
        String s = scanner.next();
        SortedSet<String> res = get(s);
        StringBuilder sb = new StringBuilder();

        if (res.size() == 0) {
            System.out.println("empty");
        } else {
            for (String re : res) {
                sb.append(re).append(" ");
            }
        }
        String result = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(result);
    }

    private static SortedSet<String> get(String s) {
        SortedSet<String> res = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<String> classList = classMap.get(s);
        SortedSet<String> set = instanceMap.get(s);

        if (set != null)
            res.addAll(set);

        if (classList != null) {
            for (int i = 0; i < classList.size(); i++) {
                String s1 = classList.get(i);
                SortedSet<String> tempSet = get(s1);
                res.addAll(tempSet);
            }
        }
        return res;
    }
}
