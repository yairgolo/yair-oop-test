package com.yair.model;

public abstract class Person {
    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    private String name;
    private int age;

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
        if (age >= 20 && age <= 120){
            this.age = age;
        } else {
            System.out.println("error age!");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
