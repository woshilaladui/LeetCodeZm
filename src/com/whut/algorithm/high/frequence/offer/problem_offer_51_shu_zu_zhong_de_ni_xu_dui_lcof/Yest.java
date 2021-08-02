package com.whut.algorithm.high.frequence.offer.problem_offer_51_shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/2 20:56
 * @desription
 */
public class Yest {

    private static void swap(String a,String b){
        String temp = a;
        a = b;
        b = temp;
    }

    private static void swap(Em A,Em B){
        Em temp = A;
        A = B;
        B = temp;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        swap(a,b);
        System.out.println(a+"  "+b);
        Em womna = new Em("womane",10);
        Em man = new Em("man",20);

//        womna.swap(womna,man);
        swap(womna,man);

        System.out.println(womna);
        System.out.println(man);
    }
}

class Em{
    String name;
    int age;

    public Em(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void swap(Em A,Em B){
        Em temp = A;
        A = B;
        B = temp;
        System.out.println(A);
        System.out.println(B);
    }

    @Override
    public String toString() {
        return "Em{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}