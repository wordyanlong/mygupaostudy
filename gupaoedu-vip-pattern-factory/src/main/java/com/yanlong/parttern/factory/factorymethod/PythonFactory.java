package com.yanlong.parttern.factory.factorymethod;

import com.gupaoedu.vip.pattern.factory.ICourse;
import com.gupaoedu.vip.pattern.factory.PythonCourse;

public class PythonFactory implements ICourseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}
