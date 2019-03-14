package com.gupaoedu.mytask.myproxy;

import com.gupaoedu.vip.pattern.proxy.Person;
import com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy.GPMeipo;
import com.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * Created by Tom on 2019/3/10.
 */
public class MyProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new MyMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
