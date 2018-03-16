package com.java_practice.stream_api;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JavaSortingWithLambdas {

    @Test
    public void basicSortWithoutLambdas(){
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Collections.sort(humans, new Comparator<Human>(){
            @Override
            public int compare(Human human1, Human human2) {
                return human1.getName().compareTo(human2.getName());
            }
        });

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    @Test
    public void basicSortWithLambdasSupport(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );
        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void basicSortWithLambdasWithNoTypeDefinition(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    @Test
    public void basicSortUsingReferenceToStaticMethod(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(Human::compareByNameThenAge);

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void basicSortWithExtractedCompator() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Collections.sort(
                humans, Comparator.comparing(Human::getName));
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    @Test
    public void basicSortWithReversingComparator(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());

        humans.sort(comparator.reversed());

        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }


    @Test
    public void basicSortWithMultipleConditions() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Zack", 12),
                new Human("Sarah", 10)
        );

        humans.sort((human1, human2) -> {
            if (human1.getName().equals(human2.getName())) {
                return human1.getAge() - human2.getAge();
            } else {
                return human1.getName().compareTo(human2.getName());
            }
        });
        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }


    @Test
    public void basicSortWithMultipleConditionsComposition() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12),
                new Human("Sarah", 10),
                new Human("Zack", 12)
        );

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
    }

}