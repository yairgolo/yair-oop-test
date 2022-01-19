package com.yair.model;

import com.yair.enums.Profession;

public class Grade {
    public Grade(Profession profession, int score) {
        this.profession = profession;
        setScore(score);
    }

    private Profession profession;
    private int score;

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score >= 40 && score <= 100){
            this.score = score;
        } else {
            System.out.println("score error");
        }
    }

    @Override
    public String toString() {
        return "Grade{" +
                "profession=" + profession +
                ", score=" + score +
                '}';
    }
}
