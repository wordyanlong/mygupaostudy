package com.yanlong.parttern.factory.factorymethod;


import com.yanlong.parttern.factory.ICourse;
import com.yanlong.parttern.factory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new JavaCourse();
    }
}
