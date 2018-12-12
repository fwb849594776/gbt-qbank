/*
 * Copyright (c) 2018 by fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank;

import com.alibaba.fastjson.JSON;
import com.fitt.gbt.qbank.common.utils.BeanUtil;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;
import java.util.Map;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : Bean Test
 * @since : 2018/11/01
 */
public class BeanTest {
    public static void main(String[] args) {
        //testBean2Map();

//        testGuavaOrdering();
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("b");
        operate(a, b);
        System.out.println(a + "." + b);
    }

    private static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    public static void testComparaObject() {
        Person person = new Person();


    }

    private static void testGuavaOrdering() {
        List<Person> xiyouji = Lists.newArrayList(
            Person.of("齐天大圣", "齐天大圣", 23, 155555444411L, null),
            Person.of("白骨精", "白骨精", 24, 155555444422L, null),
            Person.of("杨戬", "白骨精", 25, 155555444433L, null)
        );

        List<Person> shuihuzhuan = Lists.newArrayList(
            Person.of("李逵", "李逵", 20, 155555333311L, null),
            Person.of("鲁智深", "鲁智深", 21, 155555444455L, null),
            Person.of("林冲", "林冲", 29, 155555000033L, null)
        );

        List<Person> sanguoyanyi = Lists.newArrayList(
            Person.of("郭嘉", "郭嘉", 30, 155555555511L, null),
            Person.of("诸葛亮", "诸葛亮", 35, 155555111100L, null),
            Person.of("庞统", "庞统", 28, 155555222211L, null)
        );

        List<Person> hongloumeng = Lists.newArrayList(
            Person.of("贾宝玉", "贾宝玉", 18, 155555444477L, null),
            Person.of("林颦儿", "林颦儿", 16, 155555444488L, null),
            Person.of("王熙凤", "王熙凤", 20, 155555444466L, null)
        );

        List<Person> personList = Lists.newArrayList();
        personList.addAll(xiyouji);
        personList.addAll(shuihuzhuan);
        personList.addAll(sanguoyanyi);
        personList.addAll(hongloumeng);

        Ordering<Person> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, Comparable>() {
            @Override
            public Comparable apply(Person input) {
                return input.getAge();
            }
        });
        long start = System.currentTimeMillis();

        personList = ordering.sortedCopy(personList);

        //personList = personList.size() > 5 ? personList.subList(0, 5) : personList;

        for (Person person : personList) {
            System.out.println(person.toString());
        }
        long end = System.currentTimeMillis();
        System.out.println(" Guava Ordering sort cost time: " + (end - start));
    }

    private static void testBean2Map() {
        Person person = new Person();
        person.setName("bean");
        person.setAddress("com.fitt.gbt.qbank");
        person.setAge(29);

        Like like = new Like();
        like.setExt("个人爱好");
        like.setSong(Boolean.TRUE);
        like.setJump("800米");

        person.setLike(like);

        try {
            Map<String, Object> map = BeanUtil.bean2Map(person);
            map.put("a", "a");
            map.put("b", "1");
            System.out.println(JSON.toJSONString(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Person {
        private String name;
        private String address;
        private Integer age;
        private Long createTime;

        private Like like;

        public Person() {
        }

        public Person(String name, String address, Integer age, Long createTime, Like like) {
            this.name = name;
            this.address = address;
            this.age = age;
            this.createTime = createTime;
            this.like = like;
        }

        public static Person of(String name, String address, Integer age, Long createTime, Like like) {
            Person person = new Person();
            person.setName(name);
            person.setLike(like);
            person.setAge(age);
            person.setAddress(address);
            person.setCreateTime(createTime);
            return person;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Like getLike() {
            return like;
        }

        public void setLike(Like like) {
            this.like = like;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", like=" + like +
                '}';
        }
    }

    static class Like {
        private Boolean song;
        private String jump;
        private String ext;

        public Boolean getSong() {
            return song;
        }

        public void setSong(Boolean song) {
            this.song = song;
        }

        public String getJump() {
            return jump;
        }

        public void setJump(String jump) {
            this.jump = jump;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        @Override
        public String toString() {
            return "Like{" +
                "song=" + song +
                ", jump='" + jump + '\'' +
                ", ext='" + ext + '\'' +
                '}';
        }
    }
}
