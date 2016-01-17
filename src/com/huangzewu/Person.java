package com.huangzewu;

/**
 * Created by huangzewu on 1/10/16.
 */
public class Person {
    public static Person student(int age, String name, boolean sexy) {
        return new Person(age, name, sexy);
    }
    public static Person teacher(int age, String name, boolean sexy) {
        return new Person(age, name, sexy);
    }

    public final int age() {
        return age;
    }
    public final String name() {
        return name;
    }
    public final boolean sexy() {
        return sexy;
    }
    private Person(int age, String name, boolean sexy) {
        this.age = age;
        this.name = name;
        this.sexy =sexy;
    }
    private final int age;
    private final String name;
    private final boolean sexy;
}
