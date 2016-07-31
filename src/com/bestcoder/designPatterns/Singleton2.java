package com.bestcoder.designPatterns;

/**
 * Created by chentao on 16-7-31.
 * 单例模式的饿汉式[可用]
 * 访问方式 Singleton2 instance = Singleton2.getInstance();
 *
 * 优点：从它的实现中我们可以看到，这种方式的实现比较简单，在类加载的时候就完成了实例化，避免了线程的同步问题。
 * 缺点：由于在类加载的时候就实例化了，所以没有达到Lazy Loading(懒加载)的效果，也就是说可能我没有用到这个实例，
 * 但是它也会加载，会造成内存的浪费(但是这个浪费可以忽略，所以这种方式也是推荐使用的)。
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}

/**
 * 单例模式的饿汉式变换写法[可用]
 * 和上一种写法不同，没什么区别
 */
/*
public class Singleton2 {
    private static Singleton2 instance = null;
    static {
        instance = new Singleton2();
    }
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}*/
