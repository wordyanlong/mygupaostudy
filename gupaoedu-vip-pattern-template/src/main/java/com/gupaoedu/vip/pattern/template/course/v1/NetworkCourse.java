package com.gupaoedu.vip.pattern.template.course.v1;

/**
 * 模板会有一个或者多个未现实方法，
 * 而且这几个未实现方法有固定的执行循序
 * Created by Tom.
 */
public interface NetworkCourse {

    default void createCourse() {
        //1、发布预习资料
        this.postPreResource();

        //2、制作PPT课件
        this.createPPT();

        //3、在线直播
        this.liveVideo();

        //4、提交课件、课堂笔记
        this.postNote();

        //5、提交源码
        this.postSource();

        //6、布置作业，有些课是没有作业，有些课是有作业的
        //如果有作业的话，检查作业，如果没作业，完成了
        if (needHomework()) {
            checkHomework();
        }
    }

    void checkHomework();

    //钩子方法：实现流程的微调
    boolean needHomework();

    void postSource();

    void postNote();

    void liveVideo();
    void createPPT();
    void postPreResource();
}
