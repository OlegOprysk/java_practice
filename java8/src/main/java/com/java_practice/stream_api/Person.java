package com.java_practice.stream_api;


public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return name ;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
