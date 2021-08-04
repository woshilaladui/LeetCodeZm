package com.whut.study.design.pattern.builder;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:43
 * @desription
 */
public class Person {
    private String name;
    private Integer id;
    private Double height;
    private Double weight;

    public Person() {
    }

    public Person(String name, Integer id, Double height, Double weight) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public Person(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    static class Builder {
        private String name;
        private Integer id;
        private Double height;
        private Double weight;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setHeight(Double height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
