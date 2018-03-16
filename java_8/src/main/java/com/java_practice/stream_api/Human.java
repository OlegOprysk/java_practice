package com.java_practice.stream_api;

import java.util.Objects;

public class Human {

    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }


    public static int compareByNameThenAge(Human human1, Human human2){
        if(human1.getName().equals(human2.getName())){
            return human1.getAge() - human2.getAge();
        } else {
            return human1.getName().compareTo(human2.getName());
        }
    }

}
