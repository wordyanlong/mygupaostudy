package com.gupaoedu.homework.guava;

import com.google.common.eventbus.Subscribe;

public class GperTeacher {
    private String name;
    public GperTeacher(String name){
        this.name = name;
    }

    @Subscribe
    public void getQuestion(GperStudents gperQuestion){
        System.out.println(name+"老师，您收到一个"+gperQuestion.getUserName()+"学生提问的问题:"+gperQuestion.getContent());
    }
}
