package com.bestcoder.reflect;

/**
 * Created by chentao on 16-7-23.
 */
public   class  SampleInterface {
    public   static   void  main(String[] args)  throws  Exception {
        A raf = new  A();
        printInterfaceNames(raf);
    }

    public   static   void  printInterfaceNames(Object o) {
        Class c = o.getClass();
        //获取反射类的接口
        Class[] theInterfaces = c.getInterfaces();
        for ( int  i= 0 ; i<theInterfaces.length; i++)
            System.out.println(theInterfaces[i].getName());
        //获取反射类的父类（超类）
        Class theSuperclass = c.getSuperclass();
        System.out.println(theSuperclass.getName());
    }
}