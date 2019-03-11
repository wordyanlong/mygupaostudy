package com.yanlong.parttern.factory.abstractfactory;

import com.yanlong.parttern.factory.ICourse;

/**
 * 要求所有的子工厂都实现这个工厂
 * 一个品牌的抽象
 */
public interface ICourseFactory {
    ICourse createCourse();
    INote createNote();
    IVideo createVideo();
}
