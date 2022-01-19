package com.yair.model;

public class School {
    public School(ClassRoom[] classRooms) {
        setClassRooms(classRooms);
    }

    ClassRoom[] classRooms;

    public ClassRoom[] getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(ClassRoom[] classRooms) {
        if (classRooms.length == 5){
            this.classRooms = classRooms;
        } else {
            System.out.println("class room error!");
        }
    }
}
