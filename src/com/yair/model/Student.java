package com.yair.model;

import java.util.Arrays;

public class Student extends Person {
    public Student(String name, int age, Grade[] grades) {
        super(name, age);
        setGrades(grades);
    }

    Grade[] grades;

    public Grade[] getGrades() {
        return grades;
    }

    public void setGrades(Grade[] grades) {
        if (grades.length == 6) {
            this.grades = grades;
        } else {
            System.out.println("grade error!");
        }
    }

    @Override
    public String toString() {
        return "Student{\n" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                "\ngrades=" + Arrays.toString(grades) +
                '}';
    }
}
