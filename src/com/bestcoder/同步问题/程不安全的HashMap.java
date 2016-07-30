package com.bestcoder.同步问题;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by chentao on 16-7-24.
 */
public class 程不安全的HashMap {
    public static int j = 0;
    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            System.out.println(j++ +"");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
