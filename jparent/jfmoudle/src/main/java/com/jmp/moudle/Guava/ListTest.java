package com.jmp.moudle.Guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.moudle.Guava.domain.Person;

import java.util.List;

import static com.google.common.base.Predicates.and;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

public class ListTest {
    public static void main(String[] args) {
        List<Person> list = newArrayList(new Person("11", 1),
                new Person("22", 22),
                new Person("33", 33),
                new Person("44", 44),
                new Person("55", 55));

        System.err.println(JsonUtil.toJson(list));





        //年龄大于20
        List<Person> oldPeople = newArrayList(Collections2.filter(list, new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getAge() >= 20;
            }
        }));

        System.err.println(JsonUtil.toJson(oldPeople));


        //combine two function  [这里还有 and or 与的操作]
        List<Person> combList=newArrayList(Collections2.filter(list,and(ageBiggerThan(30),nameContains("5"))));

        System.err.println(JsonUtil.toJson(combList));



        //字符的获取
        List<String> names = newArrayList(transform(list, new Function<Person, String>() {
            public String apply( Person person) {
                return person.getName();
            }
        }));
        System.err.println(JsonUtil.toJson(names));
    }




    private static Predicate<Person> ageBiggerThan(final int age) {
        return new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getAge() >= age;
            }
        };
    }

    private static Predicate<Person> nameContains(final String str) {
        return new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getName().contains(str);
            }
        };
    }
}
