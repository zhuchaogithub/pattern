package com.zxc.base.study.multithreadstudy.futurestudy;

import java.util.concurrent.*;

/**
 * @author zxc
 * @date 2021/2/25 10:11
 */
public class TestFutureGet {
    public static void main(String[] args) {
            final ExecutorService exec = Executors.newFixedThreadPool(1);
            Future<String> future = exec.submit(new Callable<String>() {
                @Override
                public String call() {
                    try {
                        //开始执行耗时操作
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("任务被中断。");
                    }
                    return  "OK";
                }
            });
            try {
//            Future<String> future = exec.submit(call);
                String result = future.get(2, TimeUnit.SECONDS);
                System.out.println(result);
            } catch (InterruptedException |ExecutionException | TimeoutException e) {
                future.cancel(true); //任务停止
                System.out.println("任务超时。");
            }finally {
                System.out.println("清理资源。");
                // 关闭线程池
                exec.shutdown();
            }
    }
}
