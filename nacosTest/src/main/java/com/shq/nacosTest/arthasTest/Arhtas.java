package com.shq.nacosTest.arthasTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Arhtas {

    private static HashSet hashSet = new HashSet();

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        cpuHigh();

        deadThread();

        addHashSetThread();

        list.add("shq");
    }

    /**
     * 模拟CPU过高
     */
    public static void cpuHigh() {
        new Thread(() -> {
            while(true) {

            }
        }).start();
    }

    /**
     * 模拟线程死锁
     */
    public static void deadThread() {
        // 创建资源
        Object resourceA = new Object();
        Object resourceB = new Object();
        // 创建线程
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + " get resourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " waitting get resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "get resourceB");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + " get resourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " waitting get resourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "get resourceA");
                }
            }
        });
        threadA.start();
        threadB.start();
    }

    /**
     * 模拟oom
     */
    public static void addHashSetThread() {
        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    hashSet.add("count" + count);
                    Thread.sleep(1000);
                    count ++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
