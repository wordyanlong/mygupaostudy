package com.yanlong.parttern.factory.abstractfactory;

import com.yanlong.parttern.factory.ICourse;

public class JavaCourseFactory implements ICourseFactory {

    public ICourse createCourse() {
        return null;
    }

    public INote createNote() {
        return null;
    }

    public IVideo createVideo() {
        return null;
    }
}
