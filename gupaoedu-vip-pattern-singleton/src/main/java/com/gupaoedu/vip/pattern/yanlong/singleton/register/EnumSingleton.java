package com.gupaoedu.vip.pattern.yanlong.singleton.register;

/**
 *   // 优点: 避免反射破坏单例模式
 *   // 懒汉式的加载
 *
 */
public enum EnumSingleton {
    INSTANCE;
    private EnumSingletonObject object;

    public EnumSingletonObject getObject() {
        return object;
    }

    public void setObject(EnumSingletonObject object) {
        this.object = object;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
