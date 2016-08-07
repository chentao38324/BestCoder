package com.bestcoder.confusionCode;

/**
 * Created by chentao on 16-7-22.
 */
public class 值传递和引用传递 {

    public static void main(String []args){

        // 对象，引用传递
        Person p = new Person("张三", 20);

        p.printPerson(p);
        p.changePerson(p, "李四", 30);
        p.printPerson(p);

        // 对象，引用传递
        int []array = new int[5];
        for(int i=0; i<array.length; i++){
            array[i] = i+1;
        }
        iArray obj = new iArray();
        obj.printArray(array);
        obj.reverseArray(array);
        obj.printArray(array);


        // String类型，值传递
        String name1 = "张三";
        String name2 = "李四";

        printString(name1, name2);
        changeString(name1, name2);
        printString(name1, name2);

        // int类型，值传递
        int a = 123;
        int b = 456;

        printInt(a, b);
        changeInt(a, b);
        printInt(a, b);

        //
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Before change, sb = " + sb);
        changeData(sb);
        System.out.println("After changeData(n), sb = " + sb);
    }

    // String类型
    public static void changeString(String name1, String name2){
        String tmpName;
        tmpName = name1;
        name1 = name2;
        name2 = tmpName;
    }

    public static void printString(String name1, String name2){
        System.out.println("name1 = " + name1 + "; name2 = " + name2);
    }

    // int类型
    public static void changeInt(int a, int b){
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void printInt(int a, int b){
        System.out.println("a = " + a + "; b = " + b);
    }

    public static void changeData(StringBuffer strBuf) {
        StringBuffer sb2 = new StringBuffer("Hi ");
        strBuf = sb2;
        sb2.append("World!");
    }

    private static class iArray{

        public iArray(){

        }

        public void reverseArray(int[] array){
            int tmp;
            int len = array.length;
            for(int i=0; i<len/2; i++){
                tmp = array[i];
                array[i]= array[len-1-i];
                array[len-1-i] = tmp;
            }
        }

        public void printArray(int []array){

            for(int i=0; i<array.length; i++){
                System.out.print(array[i] + "  ");
            }
            System.out.println();
        }
    }

    // Person类
    private static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age  = age;
        }

        public void changePerson(Person person, String name, int age){
            person.name = name;
            person.age  = age;
        }

        public void printPerson(Person person){
            System.out.println("name = " + person.name + "; age = " + person.age);
        }
    }
}
