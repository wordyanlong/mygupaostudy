package com.gupaoedu.homework.guava;

import com.google.common.eventbus.EventBus;

/**
 * Created by Tom on 2019/3/17.
 */
public class GperEventTest {

    public static void main(String[] args) {
        //消息总线
        EventBus eventBus = GperNotifyEvent.getInstance();

        GperTeacher gperTeacher = new GperTeacher("tom");
        eventBus.register(gperTeacher);

        GperStudents gperQuestion = new GperStudents();
        gperQuestion.setUserName("菲菲");
        gperQuestion.setContent("老师，怎么才能变成高富帅，从此走向人生巅峰");

        eventBus.post(gperQuestion);


    }
}
