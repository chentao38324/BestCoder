package com.bestcoder.designPatterns;

/**
 * Created by chentao on 16-7-31.
 * 单例模式懒汉式双重校验锁[推荐用]
 *
 * 懒汉式变种,懒汉中最好的写法，保证了延迟加载和线程安全
 * 访问方式 Singleton instance = Singleton.getInstance();
 *
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，
 * 我们进行了两次if (instance== null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (instance== null)，直接return实例化对象。
 * 优点：线程安全；延迟加载；效率较高。
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 单例模式的懒汉式[线程不安全，不可用]
 *
 * 这种方式是在调用getInstance方法的时候才创建对象的，所以它比较懒因此被称为懒汉式。
 *
 * 有多个线程去调用getInstance方法来获取Singleton的实例，那么就有可能发生这样一种情况
 * 当第一个线程在执行if(instance==null)这个语句时，此时instance是为null的,进入语句。
 * 在还没有执行instance=new Singleton()时(此时instance是为null的)
 * 第二个线程也进入if(instance==null)这个语句，因为之前进入这个语句的线程中还没有
 * 执行instance=new Singleton()，所以它会执行instance=new Singleton()来实例化Singleton对象，
 * 因为第二个线程也进入了if语句所以它也会实例化Singleton对象。这样就导致了实例化了两个Singleton对象。
 * 所以单例模式的懒汉式是存在线程安全问题的。
 */
/*
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/

/**
 * 懒汉式线程安全的[线程安全，效率低不推荐使用]
 *
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。
 * 方法进行同步效率太低要改进。
 */
/*
public class Singleton {
    private static Singleton instance=null;
    private Singleton() {}
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}*/
