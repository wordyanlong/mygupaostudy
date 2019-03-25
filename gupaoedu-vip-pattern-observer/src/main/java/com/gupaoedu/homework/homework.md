1.思考并总结装饰者模式和适配器模式的根本区别
    装饰器与适配器都有一个别名叫做 包装模式(Wrapper)，
    它们看似都是起到包装一个类或对象的作用，但是使用它们的目的很不一一样。
    a.适配器模式的意义是要将一个接口转变成另一个接口，它的目的是通过改变接口来达到重复使用的目的。
    b.装饰器模式不是要改变被装饰对象的接口，而是恰恰要保持原有的接口，但是增强原有对象的功能，或者改变原有对象的处理方式而提升性能。
    所以这两个模式设计的目的是不同的。



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

package com.gupaoedu.homework.guava;

import com.google.common.eventbus.EventBus;

public class GperNotifyEvent {

    private static EventBus eventBus = new EventBus();

    private GperNotifyEvent() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}

package com.gupaoedu.homework.guava;

/**
 * Created by Tom on 2019/3/17.
 */
public class GperStudents {

    private String userName;
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}



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




