package com.gupaoedu.vip.pattern.template.course.v1;

/**
 * Created by Tom on 2019/3/16.
 */
public class BigDataCourse implements NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    public void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }

    @Override
    public boolean needHomework() {
        return this.needHomeworkFlag;
    }

    @Override
    public void postSource() {
        System.out.println("1");
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
