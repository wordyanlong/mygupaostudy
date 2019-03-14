package com.gupaoedu.mytask.meipoproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HeadhuntingProxy implements InvocationHandler {
    Object target;
    public Object getInstance(Object person){
        this.target = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("找到合适的公司，如果可以就安排面试");
    }

    private void before() {
        System.out.println("根据要求开始寻找合适的公司");
    }

}
