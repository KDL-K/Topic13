package com.shevlik;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String name;
    private int[] score;
    private String description;

    public Student(){}
    public Student(String name, int... score){
        this.name=name;
        setScore(score);
        setDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        int size=score.length;
        this.score=new int[size];
        for(int i=0;i<size;i++){
            this.score[i]=score[i];
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = name;
        int size=score.length;
        for(int i=0;i<size;i++){
            this.description+=" "+score[i];
        }
    }

    @Override
    public String toString() {
        return name+" "+Arrays.toString(score);
    }
}
