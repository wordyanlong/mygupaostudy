package com.yanlong.parttern.factory.factorymethod;

import com.yanlong.parttern.factory.ICourse;

/**
 * 工厂方法模式 （遵循开闭原则，增加新的产品时不需要修改原来的代码）
 */
public class FactoryMethodFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonFactory();
        ICourse course = factory.create();
        course.record();
    }
}
