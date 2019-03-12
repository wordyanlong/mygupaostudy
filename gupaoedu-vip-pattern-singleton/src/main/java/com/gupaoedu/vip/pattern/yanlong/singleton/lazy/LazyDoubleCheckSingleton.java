package com.gupaoedu.vip.pattern.yanlong.singleton.lazy;

/**
 *
 */
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton lazySimpleSingleton = null;
    private LazyDoubleCheckSingleton(){}
    public static  LazyDoubleCheckSingleton getInstance(){
        if(lazySimpleSingleton == null){
            synchronized(LazySimpleSingleton.class){
                if(lazySimpleSingleton == null){
                    lazySimpleSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySimpleSingleton;
    }
}
