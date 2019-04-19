package com.example.firsthandler;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "姓名："+name+"年龄："+age;
    }
}
