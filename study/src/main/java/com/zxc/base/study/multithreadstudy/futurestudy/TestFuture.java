package com.zxc.base.study.multithreadstudy.futurestudy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zxc
 * @date 2021/2/24 17:21
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        //等凉菜
        Callable cal = new Callable() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };

        FutureTask<String> ft1 = new FutureTask<String>(cal);
        new Thread(ft1).start();

        //等包子  必须要等待返回的结果，所以要调用join方法
        Callable cal2 = new Callable() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(cal2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long endTime = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(endTime-startTime));
    }
}
