package com.gupaoedu.vip.pattern.template.course.v1;

/**
 * Created by Tom.
 */
public class JavaCourse implements NetworkCourse {
    public void checkHomework() {
        System.out.println("检查Java的架构课件");
    }

    @Override
    public boolean needHomework() {
        return false;
    }

    @Override
    public void postSource() {

    }

    @Override
    public void postNote() {

    }

    @Override
    public void liveVideo() {

    }

    @Override
    public void createPPT() {

    }

    @Override
    public void postPreResource() {

    }
}
