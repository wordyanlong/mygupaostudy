package com.yanlong.parttern.factory.simplefactory;

import com.yanlong.parttern.factory.ICourse;

public class CourseFactory {

    public ICourse createCourse(Class<? extends  ICourse> clazz){
        try {
            if(clazz != null){
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       return null;
    }
}
