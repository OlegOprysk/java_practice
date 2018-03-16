package com.java_practice.stream_api;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    List<Person> persons;

    @Before
    public void setUp(){
        persons = Arrays.asList(
                new Person("Andrew", 22),
                new Person("Ivan", 18),
                new Person("Natalia", 22),
                new Person("Tania", 32),
                new Person("Inna", 27),
                new Person("Misha", 28)
        );
    }


    @Test
    public void terminalOperationCollect(){
        List<Person> filtered = persons.stream()
                .filter(p -> p.getName().startsWith("I"))
                .collect(Collectors.toList());

        assertTrue(2 == filtered.size());
        assertEquals("Ivan",filtered.get(0).getName());
        assertEquals("Inna",filtered.get(1).getName());
    }

    @Test
    public void terminalOperationCollectWithGroupingByCollector(){
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge.forEach((age,p) -> System.out.printf("age %s: %s\n", age, p));

        assertTrue(5 == personsByAge.size());

        assertEquals("Misha", personsByAge.get(28).get(0).getName());
        assertTrue(2 == personsByAge.get(22).size());
        assertEquals("Andrew", personsByAge.get(22).get(0).getName());
        assertEquals("Natalia", personsByAge.get(22).get(1).getName());
        assertEquals("Inna", personsByAge.get(27).get(0).getName());
    }

    @Test
    public void terminalOperationCollectWithAveragingIntCollector(){
        DecimalFormat df = new DecimalFormat(".##");
        Double averageAge = persons.stream().collect(Collectors.averagingDouble(p -> p.getAge()));

        System.out.printf("Average age is %s\n", df.format(averageAge));

        assertEquals("24.83", df.format(averageAge));
    }


    @Test
    public void terminalOperationCollectWithSummarazingIntCollector(){
        IntSummaryStatistics ageSummary = persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.getAge()));

        System.out.printf("Age summary %s", ageSummary);
        assertEquals("total count ", 6, ageSummary.getCount());
        assertEquals("total sum ", 149, ageSummary.getSum());
        assertEquals("min ", 18, ageSummary.getMin());
        assertEquals("max ", 32, ageSummary.getMax());
    }

    @Test
    public void terminalOperatinCollectWithJoiningCollector(){
        String phrase = persons
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(", ", "This is ", "."));

        System.out.printf("Result phrase : %s\n", phrase);
        assertEquals("This is Andrew, Ivan, Natalia, Tania, Inna, Misha.", phrase);
    }

    @Test
    public void terminalOperationCollectWithToMapCollector(){
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.printf("Result collecting persons List to map:\n%s\n",map);


        assertEquals(5, map.size());
        assertEquals("{32=Tania, 18=Ivan, 22=Andrew;Natalia, 27=Inna, 28=Misha}", map.toString());
        assertEquals("Andrew;Natalia", map.get(22));
    }


    @Test
    public void terminalOperationCollectWithCustomCollector(){
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(() -> new StringJoiner(" | "),    //supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),     //accumulator
                        StringJoiner::merge,                            //combiner
                        StringJoiner::toString);                        //finisher


        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.printf("Custom Collector result output:\n%s\n", names);
    }
}