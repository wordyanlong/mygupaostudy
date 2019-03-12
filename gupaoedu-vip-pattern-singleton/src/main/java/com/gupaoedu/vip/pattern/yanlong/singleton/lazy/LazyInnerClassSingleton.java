package com.gupaoedu.vip.pattern.yanlong.singleton.lazy;

public class LazyInnerClassSingleton {
    private static LazyInnerClassSingleton lazySimpleSingleton = null;
    private LazyInnerClassSingleton(){
        if(LazyHolder.lazy != null){
            throw new RuntimeException("单例只能存在一个实例");
        }
    }
    // final 保证这个方法不会被重写重载
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.lazy;
    }

    private static class LazyHolder{
        private static LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }


}
