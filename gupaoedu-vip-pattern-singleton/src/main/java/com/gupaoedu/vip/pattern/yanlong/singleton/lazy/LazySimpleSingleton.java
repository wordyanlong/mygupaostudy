package com.gupaoedu.vip.pattern.yanlong.singleton.lazy;

//懒汉式单例
//在外部需要使用的时候才进行实例化
// 优点：用到的时候才会实例化，不用的时候不会暂用内存
// 缺点：
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton = null;
    private LazySimpleSingleton(){}
    public static synchronized LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
