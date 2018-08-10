package com.jmp.moudle.Guava;

import com.jmp.moudle.Guava.domain.Person;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class MapTest {

    public static void main(String[] args) {
        List<Person> list = newArrayList(new Person("11", 1),
                new Person("22", 22),
                new Person("33", 33),
                new Person("44", 44),
                new Person("55", 55));
    }
}
