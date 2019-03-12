package com.gupaoedu.vip.pattern.yanlong.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  // 优点:对象方便管理 也是属于懒加载
 *  // 存在线程安全问题
 */
public class ContainerSingleton {
    public ContainerSingleton() {
    }
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getBean(String className){
        if(!ioc.containsKey(className)){
            Object object = null;
            try{
                object = Class.forName(className).newInstance();
                ioc.put(className,object);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }
}
