package com.yanlong.parttern.factory.simplefactory;

import com.yanlong.parttern.factory.ICourse;
import com.yanlong.parttern.factory.JavaCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.createCourse(JavaCourse.class);
        course.record();
    }
}
