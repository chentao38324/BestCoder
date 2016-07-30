package com.bestcoder.同步问题;

/**
 * Created by chentao on 16-7-24.
 */
public class Bank {

//    private int count = 0;//账户余额

    private static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    //存钱
    public void addMoney(int money) {
        count.set(count.get()+money);
        System.out.println(System.currentTimeMillis()+"存入："+money+"元");
    }

    //取钱
    public void subMoney(int money) {
        if (count.get() < money) {
            System.out.println("抱歉，余额不足！");
        }else {
            count.set(count.get()-money);
            System.out.println(System.currentTimeMillis()+"取出："+money+"元");
        }
    }

    //查询
    public void lookMoney(){
        System.out.println("账户余额："+count.get()+"元");
    }
}
