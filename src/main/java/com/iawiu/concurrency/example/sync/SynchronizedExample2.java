package com.iawiu.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample2 {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedExample2.class);

    // 修饰静态方法代码块，作用域对类
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                logger.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰静态方法，作用域对类，如果子类继承此方法，不会继承synchronized，需要自己定义synchronized
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            logger.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizedExample1.test2(1);
        });
        executorService.execute(() -> {
            synchronizedExample2.test2(2);
        });
    }
}
