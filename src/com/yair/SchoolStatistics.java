package com.yair;

import com.yair.enums.Profession;
import com.yair.model.*;

import java.util.Random;

public class SchoolStatistics {
    public static Random RND = new Random();

    public static void main(String[] args) {
        Teacher[] teachers = fillTeacher(new Teacher[5]);
        ClassRoom[] classRooms = fillClassRoom(new ClassRoom[5], teachers);
        School school = new School(classRooms);
        printSchool(school);
        System.out.println("The school average is: " + averageSchool(school));
        averageClassRoom(school);
        averageProfession(school);
        // bonus 1
        averageAge(school);
        // bonus 2
        averageGradeBonus(school);
    }


    public static void averageClassRoom(School school) {
        int conterGrade = 0;
        int scoreSum = 0;
        for (ClassRoom classRoom : school.getClassRooms()) {
            System.out.print("the " + classRoom.getName() + " average is: ");
            for (Student student : classRoom.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    conterGrade++;
                    scoreSum += grade.getScore();
                }
            }
            System.out.println(scoreSum / conterGrade);
            scoreSum = 0;
            conterGrade = 0;
        }
    }

    public static int averageSchool(School school) {
        int counterGrades = 0;
        int scoreSum = 0;
        for (ClassRoom classRoom : school.getClassRooms()) {
            for (Student student : classRoom.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    counterGrades++;
                    scoreSum += grade.getScore();
                }
            }
        }
        return scoreSum / counterGrades;
    }

    public static void printSchool(School school) {
        for (ClassRoom classRoom : school.getClassRooms()) {
            System.out.println(classRoom.getName());
            System.out.println(classRoom.getTeacher().getName() + " " + classRoom.getTeacher().getProfession().toString());
            for (Student student : classRoom.getStudents()) {
                System.out.println(student.toString());
            }
        }
    }

    public static Teacher[] fillTeacher(Teacher[] teachers) {
        Teacher[] newTeachers = new Teacher[teachers.length];
        for (int i = 0; i < newTeachers.length; i++) {
            newTeachers[i] = new Teacher("teacher" + (i + 1), RND.nextInt(100) + 20, randomEnum());
        }
        return newTeachers;
    }

    public static ClassRoom[] fillClassRoom(ClassRoom[] classRooms, Teacher[] teachers) {
        ClassRoom[] newClassRoom = new ClassRoom[classRooms.length];
        for (int i = 0; i < newClassRoom.length; i++) {
            newClassRoom[i] = new ClassRoom("room " + (i + 1), teachers[i], fillStudent(new Student[15]));
        }
        return newClassRoom;
    }

    public static Student[] fillStudent(Student[] students) {
        Student[] newStudents = new Student[students.length];
        for (int i = 0; i < newStudents.length; i++) {
            newStudents[i] = new Student("student" + (i + 1), RND.nextInt(100) + 20, fillGrades(new Grade[6]));
        }
        return newStudents;
    }

    public static Grade[] fillGrades(Grade[] grades) {
        Grade[] newGrades = new Grade[grades.length];
        for (int i = 0; i < newGrades.length; i++) {
            newGrades[i] = new Grade(Profession.values()[i], RND.nextInt(60) + 40);
        }
        return newGrades;
    }

    public static Profession randomEnum() {
        Profession[] values = Profession.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

    public static void averageAge(School school) {
        int studentCounter = 0;
        int sumStudentAge = 0;
        for (ClassRoom classRoom : school.getClassRooms()) {
            for (Student student : classRoom.getStudents()) {
                studentCounter++;
                sumStudentAge += student.getAge();
            }
        }
        System.out.println("The average student age is: " + sumStudentAge / studentCounter);
    }

    public static void averageGradeBonus(School school) {
        int studentCounter = 0;
        int gradeCounter = 0;
        int sumGrade = 0;
        for (ClassRoom classRoom : school.getClassRooms()) {
            for (Student student : classRoom.getStudents()) {
                if (student.getAge() >= 31) {
                    studentCounter++;
                    for (Grade grade : student.getGrades()) {
                        sumGrade += grade.getScore();
                        gradeCounter++;
                    }
                }
            }
        }
        System.out.println("The number of students over the age of 31 is: " + studentCounter +
                "\nThe average grade above age 31 is: " + sumGrade / gradeCounter);
    }

    public static void averageProfession(School school) {
        int mathSum = 0;
        int mathCounter = 0;
        int chemistrySum = 0;
        int chemistryCounter = 0;
        int geographySum = 0;
        int geographyCounter = 0;
        int literatureSum = 0;
        int literatureCounter = 0;
        int physicsSum = 0;
        int physicsCounter = 0;
        int sportsSum = 0;
        int sportsCounter = 0;
        for (ClassRoom classRoom : school.getClassRooms()) {
            for (Student student : classRoom.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    switch (grade.getProfession()) {
                        case MATH:
                            mathSum += grade.getScore();
                            mathCounter++;
                        case CHEMISTRY:
                            chemistrySum += grade.getScore();
                            chemistryCounter++;
                        case GEOGRAPHY:
                            geographySum += grade.getScore();
                            geographyCounter++;
                        case LITERATURE:
                            literatureSum += grade.getScore();
                            literatureCounter++;
                        case PHYSICS:
                            physicsSum += grade.getScore();
                            physicsCounter++;
                        case SPORTS:
                            sportsSum += grade.getScore();
                            sportsCounter++;
                    }
                }
            }
        }
        System.out.println("the average of math is: " + mathSum / mathCounter);
        System.out.println("the average of chemistry is: " + chemistrySum / chemistryCounter);
        System.out.println("the average of geography is: " + geographySum / geographyCounter);
        System.out.println("the average of literature is: " + literatureSum / literatureCounter);
        System.out.println("the average of physics is: " + physicsSum / physicsCounter);
        System.out.println("the average of sports is: " + sportsSum / sportsCounter);
    }
}
